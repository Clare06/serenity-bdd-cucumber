package starter.librarysystem.apiacitonsabstract;

import net.serenitybdd.core.steps.UIInteractions;
import starter.librarysystem.api.ApiUtil;
import static starter.librarysystem.apiactions.deleteactions.DeleteBookApiAction.deleteBookApiResult;
import static starter.librarysystem.apiactions.preactions.PreAction.globalBookToDelete;

public abstract class DeleteBookAbstract extends UIInteractions {

    protected void deleteBook(String role) {
        getResponseByRole(role);
    }

    protected void verifyDeleteBook(String outcome) {
        if(outcome.equalsIgnoreCase("unauthorized code 401")){
            if (deleteBookApiResult.getResponseUnauthorized().statusCode() != 401){
                throw new AssertionError("Unexpected response code: " + deleteBookApiResult.getResponseUnauthorized().statusCode());
            }
            System.out.println("He received "+outcome);
        } else if(outcome.equalsIgnoreCase("forbidden 403")){
            if (deleteBookApiResult.getResponseUser().statusCode() != 403){
                throw new AssertionError("Unexpected response code: " + deleteBookApiResult.getResponseUser().statusCode());
            }
            System.out.println("He received " + outcome);
        } else{
            if(deleteBookApiResult.getResponseAdmin().statusCode() != 200) {
                throw new AssertionError("Book deleted successfully" + outcome);
            }
            System.out.println("Book deleted successfully: " + globalBookToDelete.get(1).getTitle() + " book deleted.");
        }
    }
    private void getResponseByRole(String role) {
        ApiUtil apiUtilForUser = new ApiUtil(globalBookToDelete.get(0).getId());
        ApiUtil apiUtilForAdmin = new ApiUtil(globalBookToDelete.get(1).getId());
        ApiUtil apiUtilForUnauthorized = new ApiUtil(globalBookToDelete.get(2).getId());
        switch (role.toLowerCase()) {
            case "user":
                deleteBookApiResult.setResponseUser(apiUtilForUser.asUser().getResponseOfDeleteBook());
                break;
            case "admin":
                deleteBookApiResult.setResponseAdmin(apiUtilForAdmin.asAdmin().getResponseOfDeleteBook());
                break;
            case "unauthorized":
                deleteBookApiResult.setResponseUnauthorized(apiUtilForUnauthorized.asNonAuthorized().getResponseOfDeleteBook());
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }

    }
}
