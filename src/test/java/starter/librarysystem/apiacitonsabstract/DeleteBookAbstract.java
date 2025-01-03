package starter.librarysystem.apiacitonsabstract;

import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import static starter.librarysystem.apiactions.deleteactions.DeleteBookApiAction.deleteBookApiResult;
import static starter.librarysystem.apiactions.preactions.PreAction.globalBookToDelete;

public abstract class DeleteBookAbstract extends UIInteractions {

    protected void deleteBookByRole(String role){
        switch (role.toLowerCase()){
            case "admin":
                deleteBook("admin", globalBookToDelete.get(0).getId());
                break;
            case "user":
                deleteBook("user", globalBookToDelete.get(1).getId());
                break;
            case "unauthorized":
                deleteBook("unauthorized", globalBookToDelete.get(2).getId());
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }

    protected void deleteBook(String role, int id) {
        getResponseByRole(role, id);
    }

    protected void verifyDeleteBook(String outcome) {
        if(outcome.equalsIgnoreCase("unauthorized 401")){
            if (deleteBookApiResult.getResponseUnauthorized().statusCode() != 401){
                throw new AssertionError("Unexpected response code: " + deleteBookApiResult.getResponseUnauthorized().statusCode());
            }
            System.out.println("He received "+outcome);
        } else if(outcome.equalsIgnoreCase("forbidden 403")){
            if (deleteBookApiResult.getResponseUser().statusCode() != 403){
                throw new AssertionError("Unexpected response code: " + deleteBookApiResult.getResponseUser().statusCode());
            }
            System.out.println("He received " + outcome);
        } else if(outcome.equalsIgnoreCase("not found 404")){
            if (deleteBookApiResult.getResponseUser().statusCode() != 404){
                throw new AssertionError("Unexpected response code: " + deleteBookApiResult.getResponseUser().statusCode());
            }
            System.out.println("He received " + outcome);
        } else{
            if(deleteBookApiResult.getResponseAdmin().statusCode() != 200) {
                throw new AssertionError("Unexpected response code: " + deleteBookApiResult.getResponseUser().statusCode());
            }
            System.out.println("Book deleted successfully");
        }
    }
    private void getResponseByRole(String role, int id) {
        ApiUtil apiUtil = new ApiUtil(id);
        switch (role.toLowerCase()) {
            case "user":
                deleteBookApiResult.setResponseUser(apiUtil.asUser().getResponseOfDeleteBook());
                break;
            case "admin":
                deleteBookApiResult.setResponseAdmin(apiUtil.asAdmin().getResponseOfDeleteBook());
                break;
            case "unauthorized":
                deleteBookApiResult.setResponseUnauthorized(apiUtil.asNonAuthorized().getResponseOfDeleteBook());
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }

    }
}
