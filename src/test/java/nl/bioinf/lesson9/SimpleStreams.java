package nl.bioinf.lesson9;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStreams {

    @Test
    void testListStream() {
        List<Integer> numbers = List.of(3, 2, 4, 8, 10, 1, 0, 2, 9);
        numbers.stream()
                .filter(SimpleStreams::test)
                .peek(System.out::println)
                .map(n -> n*n)
                .sorted((o1, o2) -> Integer.compare(o2, o1))
                .forEach(System.out::println);
    }

    //custom Predicate as static function
    static boolean test(Integer n) {
        return n > 5;
    }

    public record GlobalTemp(String source, int year, double mean) {

        public static GlobalTemp fromCsv(String csvLine) {
            //GCAG,2016,0.9363
            String[] elements = csvLine.split(",");
            String source = elements[0];
            int year = Integer.parseInt(elements[1]);
            double meanTemp = Double.parseDouble(elements[2]);
            return new GlobalTemp(source, year, meanTemp);
        }
    }

    @Test
    void testCreateGlobalTemp() {
        GlobalTemp globalTemp = GlobalTemp.fromCsv("GCAG,2016,0.9363");
        System.out.println(globalTemp);
    }

    @Test
    void globalTemperature() {
        String fileName = "data/annual.csv";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<GlobalTemp> gcagGlobalTemp = stream
                    .skip(1)
                    .map(GlobalTemp::fromCsv)
                    .filter(gt -> gt.source().equals("GCAG"))
                    .sorted(Comparator.comparingDouble(GlobalTemp::mean))//(o1, o2) -> Double.compare(o2.mean(), o1.mean()))
                    .limit(10)
                    .peek(System.out::println)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void globalTemperature2() {
        String fileName = "data/annual.csv";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            Map<String, List<GlobalTemp>> collect = stream
                    .skip(1)
                    .map(GlobalTemp::fromCsv)
                    .sorted((o1, o2) -> Double.compare(o2.mean(), o1.mean()))
                    .limit(10)
                    .peek(System.out::println)
                    .collect(Collectors.groupingBy(GlobalTemp::source));

            System.out.println(collect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
