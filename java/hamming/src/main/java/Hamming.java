import java.util.stream.IntStream;

class Hamming {
    static int compute(String dnaStrand, String mutatedDnaStrand) {
        if (dnaStrand.length() != mutatedDnaStrand.length())
            throw new IllegalArgumentException("The DNA strands need to be of equal length.");

        return IntStream.range(0, dnaStrand.length())
                .map(index -> dnaStrand.charAt(index) == mutatedDnaStrand.charAt(index) ? 0 : 1)
                .sum();
    }
}
