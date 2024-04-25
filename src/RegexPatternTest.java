import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternTest {
    static Pattern EXTRACT_METHOD_NAME_PATTERN = Pattern.compile("^\\s*method\\s+([^\\.]+)\\s*\\.", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

    public static void main(String[] args) {
        String[] methodSources = new String[] {
                """
                METHOD speed_up.
                    speed = speed + step.
                    IF speed &gt; max_speed.
                      speed = max_speed.
                    ENDIF.
                ENDMETHOD.
                """,
                """
                METHOD increase_price BY DATABASE PROCEDURE FOR HDB
                                       LANGUAGE SQLSCRIPT
                                       USING sflight.
                update sflight set price = price + :inc
                               where mandt = :clnt;
                ENDMETHOD.
                """,
                """
                METHOD : speed_up2.
                    speed = speed + step.
                    IF speed &gt; max_speed.
                      speed = max_speed.
                    ENDIF.
                ENDMETHOD.
                """,
                """
                METHOD: speed_up3.
                    speed = speed + step.
                    IF speed &gt; max_speed.
                      speed = max_speed.
                    ENDIF.
                ENDMETHOD.
                """,
                """
                METHOD GET_USERS from /GLB/CL_YGTPP_AMDP_AMS_SEARCH=CM001 for /GLB/CL_YGTPP_AMDP_AMS_SEARCH.
                    speed = speed + step.
                    IF speed &gt; max_speed.
                      speed = max_speed.
                    ENDIF.
                ENDMETHOD.
                """,
                """
                METHOD DUMMY ##NEEDED from /GLB/CL_YGTFC_MORE_ENH========CM005
                .
                    speed = speed + step.
                    IF speed &gt; max_speed.
                      speed = max_speed.
                    ENDIF.
                ENDMETHOD.
                """
        };
        for (String methodSrc : methodSources) {
            System.out.println("-------------------------------------------");
            System.out.println("For " + methodSrc.lines().findFirst().get());
            Matcher m = EXTRACT_METHOD_NAME_PATTERN.matcher(methodSrc);
            if (m.find()) {
                System.out.println("Found pattern..");
                System.out.println(m.group(1));
            }

        }
    }
}
