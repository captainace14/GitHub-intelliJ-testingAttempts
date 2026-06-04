package mutationTesting;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MutationSlayerAssignments {

    // =========================================================================
    // Case 2: Math Operator Mutator (Changes + to -)
    // =========================================================================
    public int addPremium(int price) {

        return price + 50;}

    @Test
    public void killMathMutation(){
        // summation operation requires
        int result = addPremium(100);
        assertEquals(150, result, "Premium calculation must add exactly 50 units.");

    }

    // =========================================================================
    // Case 3: Negate Conditional Mutator (Inverts "if (flag)" to "if (!flag)")
    // =========================================================================

        public String getStatus(boolean isActive ) {
            return isActive ? "ONLINE" : "OFFLINE";
        }

        @Test
        void killNegateConditionalMutation() {
        //We must assert BOTH pathways to kill conditional inversion mutations completely.
            assertEquals("ONLINE", getStatus(true), "True input must yield ONLINE.");
            assertEquals("OFFLINE", getStatus(false), "False input must yield OFFLINE.");
        }

    // =========================================================================
    // Case 4: Return Value Mutator (Forces an Object method to return null)
    // ========================================================================

    public String createToken() { return "TOKEN_SECURE_123"; }

    @Test
    void killReturnValueMutation() {
        String token = createToken();
        assertNotEquals(token,"Generated token mustn't be null.");
        assertEquals("TOKEN_SECURE_123", token, "Token content must match system specs.");
    }


    // =========================================================================
    // Case 5: Increments Mutator (Changes i++ to i--)
    // =========================================================================

    public int[] doubleFirstElement(int[] input){
        input[0]++;
        return input;
    }

    @Test
    void killIncrementMutation() {
        int[] sourceArray = {10, 20};
        int[] result = doubleFirstElement(sourceArray);

        assertEquals(11, result[0], "First index element must be incremented by one.");
    }

    // =========================================================================
    // Case 6: Void Method Call Removal Mutator (Deletes lines of code completely)
    // =========================================================================

    public class AuditTrail {
        private boolean logCalled = false;
        public void writeLog() { this.logCalled = true;}
        public boolean isLogCalled() { return logCalled; }
    }

    @Test
    void killVoidMethodRemovalMutation() {
        AuditTrail auditTrail = new AuditTrail();
        // If a mutator completely deletes the invocation line below, logCalled stays false
        auditTrail.writeLog();
        assertTrue(auditTrail.isLogCalled(), "Executing the audit flow must toggle logging state to true.");
    }

    // =========================================================================
    // Case 7: Inline Constant Mutator (Changes an internal string value)
    // =========================================================================

    public String getDomainUrl() { return "https://yeditepe.edu.tr"; }

    @Test
    void killInlineConstantMutation() {
        assertEquals("https://yeditepe.edu.tr", getDomainUrl(), "Domain URL string endpoint must match exactly.");
    }

    // =========================================================================
    // Case 8: Switch Fallthrough Mutator (Removes break statements)
    // =========================================================================

    public int getPriorityValue(char tier){
        switch (tier){
            case 'A' : return 1;
            case 'B' : return 2;
            default  : return 3;
        }
    }

    @Test
    void killSwitchFallthroughMutation() {
     assertEquals(1, getPriorityValue('A'), "Tier A priority value must scale to 1.");
     assertEquals(2, getPriorityValue('B'), "Tier B priority value must scale to 2.");
     assertEquals(3, getPriorityValue('C'), "Default tier parameters must scale to 3.");
    }

    // =========================================================================
    // Case 9: Empty Object Return Mutator (Forces collections to return Collections.emptyList())
    // =========================================================================


    List<String> getItems(){
        return List.of("A", "B");
    }

    @Test
    void killEmptyReturnMutation() {
        List<String> resultList = getItems();
        //If mutated to return Collections.emptyList(), size check kills it instantly.
        assertEquals(2, resultList.size(), "Returned list must contain exactly 2 registered entries.");
        assertTrue(resultList.contains("A"), "List must contain element item 'A'. ");
    }

    // =========================================================================
    // Case 10: Loop Counter Bound Mutator (Alters termination rules in loops)
    // =========================================================================

    public int countCharacters(String context) {
        int sum = 0;
        for (int i = 0; i < context.length(); i++){
            sum++;
        }
        return sum;
    }

    @Test
    void killLoopBoundMutation() {
        //If condition changes to (i <= length) or (i < length - 1), count fails.
        assertEquals(4, countCharacters("test"), "Character counter tracker loops must return exact counts.");
    }
}
