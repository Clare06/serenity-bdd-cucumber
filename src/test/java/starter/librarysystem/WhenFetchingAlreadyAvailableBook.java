package starter.librarysystem;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import starter.librarysystem.apiactions.GetBookListApiAction;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenFetchingAlreadyAvailableBook {

    GetBookListApiAction libraryApi;

    @Test
    public void fetchAlreadyAvailablePet() {
        libraryApi.theLibraryApiIsAvailable();
        libraryApi.fetchBookList();
        libraryApi.verifyBookList();

    }
}