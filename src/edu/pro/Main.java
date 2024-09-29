package edu.pro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /*
     * Метод для очищення тексту: замінює всі символи, окрім літер та пробілів, на пробіли,
     * перетворює всі літери в нижній регістр та прибирає зайві пробіли.
     */
    public static String cleanText(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        
        // Замінюємо всі символи, окрім літер, на пробіли та приводимо до нижнього регістру
        return content.replaceAll("[^A-Za-z ]", " ")
                .toLowerCase(Locale.ROOT)
                .trim();  // Прибираємо зайві пробіли на початку та в кінці
    }

    public static void main(String[] args) throws IOException {
        // Збереження часу початку виконання програми
        LocalDateTime start = LocalDateTime.now();
        
        // Читання та очищення тексту з файлу
        String content = cleanText("src/edu/pro/txt/harry.txt");

        // Розділяємо текст на окремі слова за пробілами
        String[] words = content.split("\\s+");  // "\\s+" — регулярний вираз для одного або більше пробілів

        // Обчислюємо частоту кожного слова за допомогою Streams
        Map<String, Long> wordFrequencies = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())); 
                // Групуємо однакові слова та підраховуємо їх кількість

        // Сортуємо слова за їх частотою
        List<Map.Entry<String, Long>> sortedWordFrequencies = wordFrequencies.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())  // Сортуємо за значенням (частота)
                .toList();  // Зберігаємо відсортовані пари в список

        // Виводимо 30 найчастіших слів
        for (int i = 0; i < 30 && i < sortedWordFrequencies.size(); i++) {
            Map.Entry<String, Long> entry = sortedWordFrequencies.get(sortedWordFrequencies.size() - 1 - i);
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Збереження часу завершення виконання програми
        LocalDateTime finish = LocalDateTime.now();
        
        // Обчислення і виведення часу виконання програми в мілісекундах
        System.out.println("------");
        System.out.println(ChronoUnit.MILLIS.between(start, finish));
    }
}
