package unitTesting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RemoteFileMappingTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/user_profiles.csv", numLinesToSkip = 1)
    public void testLoadedProfileData(String identityKey, String privelegeGroup, boolean isVerifiedState){
        assertNotNull(identityKey);
    }

}

