package test;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author xiaozhou.tu
 * @date 2022/10/8
 */
public class A {

    private static final String MODEL_YEAR = "MODEL YEAR";
    private static final String AND = "AND";
    private static final String OR = "OR";
    private static final String COLON = ":";
    private static final Pattern pattern = Pattern.compile("^([a-zA-Z\\d]+: MODEL YEAR\\{[^{}]+\\}\n?)+$");

    public static void main(String[] args) throws Exception {
        String json = FileUtils.readFileToString(new File("/Users/xiaozhou.tu/boms_ebom.json"), "UTF-8");
        List<B> bList = JSONArray.parseArray(json, B.class);
        int selectCount = 0;
        for (int i = 0; i < bList.size(); i++) {
            String result = parseModelYearFromUsage(bList.get(i).getOld_usage());
            if (isBlank(result)) {
                System.out.println("isBlank");
                continue;
            }
            if (!result.contains(MODEL_YEAR)) {
                System.out.println(bList.get(i).getId() + "\t\t" + result + "\t\t[xxxx]" + bList.get(i).getOld_usage());
                continue;
            }
            selectCount++;
            if (!pattern.matcher(result).matches()) {
                System.out.println(bList.get(i).getId() + "\t\t" + result);
            }
//            int startIndex = result.indexOf(MODEL_YEAR);
//            startIndex = result.indexOf(MODEL_YEAR, startIndex +1);
//            if (startIndex > 0) {
//                System.out.println(bList.get(i).getId() + "\t\t" + result + "\t\txxxx" + bList.get(i).getOld_usage());
//            }
        }
        System.out.println(bList.size());
        System.out.println(selectCount);
    }

    private static String parseModelYearFromUsage(String usage) {
        // ES6: MODEL YEAR{G1.1,G1.2} AND FRT ST HEAT{FRT ST HEAT} AND FRT ST VENT{N FRT ST VENT} AND FRT ST MAS{N FRT ST MAS} AND INT MTL{LEATHER}
        if (isBlank(usage) || !usage.contains(MODEL_YEAR)) {
            return usage;
        }
        int startIndex = usage.indexOf(MODEL_YEAR);
        int andIndex = usage.indexOf(AND, startIndex);
        int orIndex = usage.indexOf(OR, startIndex);
        int endIndex = usage.length();
        if (andIndex > 0) {
            endIndex = Math.min(endIndex, andIndex);
        }
        if (orIndex > 0) {
            endIndex = Math.min(endIndex, orIndex);
        }
        String modelYear = usage.substring(startIndex, endIndex).trim();
        if (!usage.contains(COLON)) {
            return modelYear;
        }
        String model = usage.substring(0, usage.indexOf(COLON) + 1);
        return model + " " + modelYear;
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    @Data
    private static class B {

        private Long id;

        private String old_usage;

    }

}
