package ua.procamp;

import ua.procamp.exception.EntityNotFoundException;
import ua.procamp.model.Account;
import ua.procamp.model.Sex;

import java.math.BigDecimal;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

/**
 * Implement methods using Stream API
 */
public class AccountAnalytics {
    private Collection<Account> accounts;

    public static AccountAnalytics of(Collection<Account> accounts) {
        return new AccountAnalytics(accounts);
    }

    private AccountAnalytics(Collection<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Returns {@link Optional} that contains an {@link Account} with the max value of balance
     *
     * @return account with max balance wrapped with optional
     */
    public Optional<Account> findRichestPerson() {
        Optional<Account> account = accounts.stream().max(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getBalance().compareTo(o2.getBalance());
            }
        });

        return account;
    }

    /**
     * Returns a {@link //List} of {@link Account} that have a birthday month equal to provided.
     *
     * @param birthdayMonth a month of birth
     * @return a list of accounts
     */
    public List<Account> findAccountsByBirthdayMonth(Month birthdayMonth) {
        return accounts.stream().filter(account -> account.getBirthday().getMonth().equals(birthdayMonth)).collect(Collectors.toList());

    }

    /**
     * Returns a map that separates all accounts into two lists - male and female. Map has two keys {@code true} indicates
     * male list, and {@code false} indicates female list.
     *
     * @return a map where key is true or false, and value is list of male, and female accounts
     */
    public Map<Boolean, List<Account>> partitionMaleAccounts() {
        List<Account> male = accounts.stream().filter(account -> account.getSex().equals(Sex.MALE)).collect(Collectors.toList());
        List<Account> female = accounts.stream().filter(account -> account.getSex().equals(Sex.FEMALE)).collect(Collectors.toList());
        return Map.of(Boolean.TRUE, male, Boolean.FALSE, female);


    }

    /**
     * Returns a {@link Map} that stores accounts grouped by its email domain. A map key is {@link String} which is an
     * email domain like "gmail.com". And the value is a {@link //List} of {@link Account} objects with a specific email domain.
     *
     * @return a map where key is an email domain and value is a list of all account with such email
     */
    public Map<String, List<Account>> groupAccountsByEmailDomain() {
        Map<String, List<Account>> listMap = new HashMap<>();
        List<String> domains = accounts.stream().map(s -> s.getEmail().substring(s.getEmail().indexOf("@") + 1)).distinct().collect(Collectors.toList());
        domains.forEach(s -> listMap.put(s, accounts.stream().filter(acc -> acc.getEmail().substring(acc.getEmail().indexOf("@") + 1).equals(s)).collect(Collectors.toList())));
        return listMap;
    }

    /**
     * Returns a number of letters in all first and last names.
     *
     * @return total number of letters of first and last names of all accounts
     */
    public int getNumOfLettersInFirstAndLastNames() {
        return accounts.stream().mapToInt(s -> s.getLastName().length() + s.getFirstName().length()).sum();
    }

    /**
     * Returns a total balance of all accounts.
     *
     * @return total balance of all accounts
     */
    public BigDecimal calculateTotalBalance() {
        return accounts.stream().reduce(new BigDecimal(0), (first, second) -> first.add(second.getBalance()), (third, second) -> third.add(second));
    }

    /**
     * Returns a {@link //List} of {@link Account} objects sorted by first and last names.
     *
     * @return list of accounts sorted by first and last names
     */
    public List<Account> sortByFirstAndLastNames() {
        return accounts.stream().sorted(Comparator.comparing(Account::getLastName)).sorted(Comparator.comparing(Account::getFirstName)).collect(Collectors.toList());
    }

    /**
     * Checks if there is at least one account with provided email domain.
     *
     * @param emailDomain
     * @return true if there is an account that has an email with provided domain
     */
    public boolean containsAccountWithEmailDomain(String emailDomain) {
        return accounts.stream().anyMatch(a -> substringAnEmail(a.getEmail()).equals(emailDomain));
    }

    public static String substringAnEmail(String email){
        return email.substring(email.indexOf("@")+1);
    }

    /**
     * Returns account balance by its email. Throws {@link EntityNotFoundException} with message
     * "Cannot find Account by email={email}" if account is not found.
     *
     * @param email account email
     * @return account balance
     */
    public BigDecimal getBalanceByEmail(String email) {
        return accounts.stream().filter(s -> s.getEmail().equals(email)).findAny().orElseThrow(()
                -> new EntityNotFoundException("Cannot find Account by email=" + email)).getBalance();
    }

    /**
     * Collects all existing accounts into a {@link Map} where a key is account id, and the value is {@link Account} instance
     *
     * @return map of accounts by its ids
     */
    public Map<Long, Account> collectAccountsById() {
        return accounts.stream().collect(Collectors.toMap(s -> s.getId(), s -> s));


    }

    /**
     * Filters accounts by the year when an account was created. Collects account balances by its emails into a {@link Map}.
     * The key is {@link Account#//email} and the value is {@link Account#//balance}
     *
     * @param year the year of account creation
     * @return map of account by its ids the were created in a particular year
     */
    public Map<String, BigDecimal> collectBalancesByIdForAccountsCreatedOn(int year) {
        return accounts.stream().filter(s -> s.getCreationDate().getYear() == year).collect(Collectors.toMap(e -> e.getEmail(), b -> b.getBalance()));
    }

    /**
     * Returns a {@link Map} where key is {@link Account#//lastName} and values is a {@link Set} that contains first names
     * of all accounts with a specific last name.
     *
     * @return a map where key is a first name and value is a set of first names
     */
    public Map<String, Set<String>> groupFirstNamesByLastNames() {
        Map<String, Set<String>> stringSetMap = new HashMap<>();
        accounts.stream().forEach(e -> {
            stringSetMap.put(e.getLastName(), accounts.stream().filter(account -> account.getLastName().equals(e.getLastName()))
                    .map(Account::getFirstName).collect(Collectors.toSet()));
        });
        return stringSetMap;
    }

    /**
     * Returns a {@link Map} where key is a birthday month, and value is a {@link String} that stores comma and space
     * -separated first names (e.g. "Polly, Dylan, Clark"), of all accounts that have the same birthday month.
     *
     * @return a map where a key is a birthday month and value is comma-separated first names
     */
    public Map<Month, String> groupCommaSeparatedFirstNamesByBirthdayMonth() {
        return accounts.stream().collect(groupingBy(a -> a.getBirthday().getMonth(), mapping(Account::getFirstName, joining(", "))));
    }

    /**
     * Returns a {@link Map} where key is a {@link Month} of {@link Account#//creationDate}, and value is total balance
     * of all accounts that have the same value creation month.
     *
     * @return a map where key is a creation month and value is total balance of all accounts created in that month
     */
    public Map<Month, BigDecimal> groupTotalBalanceByCreationMonth() {
        return accounts.stream().collect(groupingBy(a -> a.getCreationDate().getMonth(), mapping(Account::getBalance, reducing(BigDecimal.ZERO, BigDecimal::add))));
    }

    /**
     * Returns a {@link Map} where key is a letter {@link Character}, and value is a number of its occurrences in
     * {@link Account#//firstName}.
     *
     * @return a map where key is a letter and value is its count in all first names
     */
    public Map<Character, Long> getCharacterFrequencyInFirstNames() {
        return accounts.stream()
                .map(Account::getFirstName).flatMapToInt(String::chars).mapToObj(c -> (char) c).collect(groupingBy(identity(), counting()));
    }


    /**
     * Returns a {@link Map} where key is a letter {@link Character}, and value is a number of its occurrences ignoring
     * case, in all {@link Account#//firstName} and {@link Account#//lastName}. All letters should stored in lower case.
     *
     * @return a map where key is a letter and value is its count ignoring case in all first and last names
     */
    public Map<Character, Long> getCharacterFrequencyIgnoreCaseInFirstAndLastNames() {
        return accounts.stream().flatMap(a -> Stream.of(a.getFirstName(), a.getLastName())).map(String::toLowerCase)
                .flatMapToInt(String::chars).mapToObj(c -> (char) c).collect(groupingBy(identity(), counting()));
    }

}

