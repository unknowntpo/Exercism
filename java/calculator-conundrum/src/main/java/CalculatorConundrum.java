class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        return switch (operation)
        {
            case "+" -> String.format("%d + %d = %d", operand1, operand2, operand1 + operand2);
            case "-" -> String.format("%d / %d = %d", operand1, operand2, operand1 - operand2);
            case "*" -> String.format("%d * %d = %d", operand1, operand2, operand1 * operand2);
            case "/" -> {
                try {
                    yield String.format("%d / %d = %d", operand1, operand2, operand1 / operand2);
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Division by zero is not allowed", e);
                }
            }
            case "" -> throw new IllegalArgumentException("Operation cannot be empty");
            default -> throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        };
    }
}
