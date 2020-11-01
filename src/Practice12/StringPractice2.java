package Practice12;



import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPractice2 {
    public static void main(String[] args) {
        int isName = 0;
        String surname = "Фамилия: ", name = "Имя: ", patronymic = "Отчество: ";
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        Pattern check = Pattern.compile("^[А-Я]{0,1}[а-я]+[-]{0,1}[А-Я]{0,1}[а-я]+\\s[А-Я][а-я]{1,}\\s[А-Я][а-я]{1,}$");
        Matcher matcherCheck = check.matcher(text);
        if (!matcherCheck.find()){
            check = Pattern.compile("^[А-Я]{0,1}[а-я]+[-]{0,1}[А-Я]{0,1}[а-я]+\\s[А-Я][а-я]{1,}$");
            matcherCheck = check.matcher(text);
            if (!matcherCheck.find()){
                System.out.println("Введенная строка не является ФИО");
                System.exit(0);
            }
        }

        Pattern pattern = Pattern.compile("^[А-Я]{0,1}[а-я]+[-]{0,1}[А-Я]{0,1}[а-я]+\\s");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
                System.out.println(surname + text.substring(matcher.start(), matcher.end()));


        }
        pattern = Pattern.compile("\\s[А-Я][а-я]{1,}");
        matcher = pattern.matcher(text);
        while (matcher.find())
                if (isName == 0) {
                    System.out.println(name + text.substring(matcher.start() + 1, matcher.end()));
                    isName++;
                }
                  else  {
                    System.out.println(patronymic + text.substring(matcher.start() + 1, matcher.end()));
                }
    }


    }

