package seminar_02;
import java.util.Map;
import java.util.HashMap;


public class Task1 {
    /*1) Дана строка sql-запроса "select * from students where ".
    Сформируйте часть WHERE этого запроса, используя StringBuilder.
    Данные для фильтрации приведены ниже в виде json строки.
    Если значение null, то параметр не должен попадать в запрос.
    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Evgenia\", \"country\":\"Russian Federation\", \"city\":\"null\", \"age\":\"33\"}";


        // содержит ключи и значения в строке WHERE
        Map<String, String> filters = new HashMap<String, String>() {{
            put("name", "name");
            put("country", "country");
            put("city", "city");
            put("age", "age");
        }};
        // оператор WHERE используется в SQL для определения условия для выборки данных
       
        StringBuilder whereRequest = new StringBuilder();
        whereRequest.append("select * from students where ");
        // условия для фильтрации:
        for (String key : filters.keySet()) {
            String value = filters.get(key);
            String filterValue = getValueFromJson(jsonString, key);
            // если значения не равны null, добавляем их в строку WHERE
            if (filterValue != null && !"null".equals(filterValue)) {
                if (whereRequest.length() > 27) {
                    whereRequest.append("and ");
                }
                if ("age".equals(value)) { // если age просто добавляем
                    whereRequest.append("age = ").append(filterValue);
                } else { // если значение другое то заключить в кавычки
                    whereRequest.append(value).append(" = '").append(filterValue).append("' ");
                }
            }
        }


        System.out.println(whereRequest);
    }


    // метод разбивает строку на значения атрибутов и возвращает значение атрибута по ключу.
    private static String getValueFromJson(String json, String key) {
        String[] splitParts = json.split("\"" + key + "\":");
        if (splitParts.length > 1) {
            int endIndex = splitParts[1].indexOf(",");
            if (endIndex == -1) {
                endIndex = splitParts[1].indexOf("}");
            }
            String value = splitParts[1].substring(0, endIndex);
            return value.replaceAll("\"", "").trim();
        } else {
            return null;
        }
    }
}
