package com.namegen.model;

import java.util.*;

/**
 * The NameGenerator class handles the generation of names based on different ancient languages
 * and gender preferences.
 */
public class NameGenerator {
    private final Map<String, List<String>> prefixes;
    private final Map<String, List<String>> suffixes;
    private final Map<String, List<String>> middleParts;
    private final Random random;

    /**
     * Constructor initializes the name components for different language categories.
     */
    public NameGenerator() {
        random = new Random();
        prefixes = new HashMap<>();
        suffixes = new HashMap<>();
        middleParts = new HashMap<>();
        
        initializeLatinComponents();
        initializeGreekComponents();
        initializeNorseComponents();
        initializeEgyptianComponents();
        initializeSanskritComponents();
    }

    /**
     * Generates a specified number of names based on language and gender preferences.
     *
     * @param language The chosen language category
     * @param gender The preferred gender for the names
     * @param count Number of names to generate
     * @return List of generated names
     */
    public List<String> generateNames(String language, String gender, int count) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            names.add(generateSingleName(language, gender));
        }
        return names;
    }

    /**
     * Generates a single name based on the specified parameters.
     *
     * @param language The chosen language category
     * @param gender The preferred gender for the name
     * @return A generated name
     */
    private String generateSingleName(String language, String gender) {
        List<String> languagePrefixes = prefixes.get(language);
        List<String> languageSuffixes = suffixes.get(language);
        List<String> languageMiddle = middleParts.get(language);

        if (languagePrefixes == null || languageSuffixes == null) {
            throw new IllegalArgumentException("Invalid language category");
        }

        String prefix = languagePrefixes.get(random.nextInt(languagePrefixes.size()));
        String suffix = languageSuffixes.get(random.nextInt(languageSuffixes.size()));
        
        // 50% chance to add a middle part for longer names
        if (random.nextBoolean() && languageMiddle != null) {
            String middle = languageMiddle.get(random.nextInt(languageMiddle.size()));
            return prefix + middle + suffix;
        }
        
        return prefix + suffix;
    }

    private void initializeLatinComponents() {
        prefixes.put("Latin", Arrays.asList("Aur", "Caes", "Dec", "Flav", "Jul", "Luc", "Marc", "Oct", "Pub", "Tit"));
        suffixes.put("Latin", Arrays.asList("ius", "us", "a", "illa", "inus", "or", "ix", "ena", "ana", "ianus"));
        middleParts.put("Latin", Arrays.asList("el", "ian", "il", "in", "on"));
    }

    private void initializeGreekComponents() {
        prefixes.put("Greek", Arrays.asList("Alex", "Andr", "Call", "Dem", "Hel", "Phil", "Soph", "The", "Xen", "Zer"));
        suffixes.put("Greek", Arrays.asList("os", "us", "is", "as", "es", "ia", "ion", "or", "us", "ius"));
        middleParts.put("Greek", Arrays.asList("and", "ip", "op", "eth"));
    }

    private void initializeNorseComponents() {
        prefixes.put("Norse", Arrays.asList("Bjor", "Eir", "Frey", "Gun", "Heim", "Ing", "Sig", "Thor", "Ulf", "Yng"));
        suffixes.put("Norse", Arrays.asList("ald", "ar", "ild", "ulf", "und", "or", "ir", "mar", "mund", "rid"));
        middleParts.put("Norse", Arrays.asList("grim", "rik", "vig", "bjorn"));
    }

    private void initializeEgyptianComponents() {
        prefixes.put("Egyptian", Arrays.asList("Amen", "Hor", "Khen", "Men", "Nef", "Ptah", "Ra", "Set", "Thut", "Wes"));
        suffixes.put("Egyptian", Arrays.asList("hotep", "amon", "mose", "ankh", "ari", "tet", "is", "ut", "em", "ra"));
        middleParts.put("Egyptian", Arrays.asList("en", "ka", "ma", "nu"));
    }

    private void initializeSanskritComponents() {
        prefixes.put("Sanskrit", Arrays.asList("Abhi", "Adi", "Dev", "Hari", "Ind", "Kris", "Mah", "Raj", "Sur", "Vish"));
        suffixes.put("Sanskrit", Arrays.asList("ant", "it", "ana", "a", "i", "am", "an", "ya", "raj", "dev"));
        middleParts.put("Sanskrit", Arrays.asList("esh", "end", "ath", "ang"));
    }

    /**
     * Returns the available language categories.
     *
     * @return Set of available language categories
     */
    public Set<String> getAvailableLanguages() {
        return prefixes.keySet();
    }
} 