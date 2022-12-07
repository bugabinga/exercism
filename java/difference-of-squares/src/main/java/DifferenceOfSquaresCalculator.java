class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = 0;
        int number = input;
        while (number > 0) {
            sum = sum + number;
            number = number - 1;
        }
        return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
        int sum = 0;
        int number = input;
        while (number > 0) {
            sum = sum + number * number;
            number = number - 1;
        }
        return sum;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
