/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 *
 * Created by Yan on 12/3/15.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int length = ver1.length < ver2.length ? ver1.length : ver2.length;
        for (int i = 0; i < length; i++) {
            int subver1 = Integer.parseInt(ver1[i]);
            int subver2 = Integer.parseInt(ver2[i]);
            if (subver1 < subver2)
                return -1;
            if (subver1 > subver2)
                return 1;
        }
        if (ver1.length == ver2.length)
            return 0;
        else if (ver1.length > ver2.length) {
            for (int i = ver2.length ; i < ver1.length; i++)
                if (Integer.parseInt(ver1[i]) != 0)
                    return 1;
            return 0;
        }
        else {
            for (int i = ver1.length ; i < ver2.length; i++)
                if (Integer.parseInt(ver2[i]) != 0)
                    return 1;
            return 0;
        }
    }

    public static void main(String[] args) {
        CompareVersionNumbers test = new CompareVersionNumbers();
        String v1 = "1.0";
        String v2 = "1.0.0.0.0";
        System.out.println(test.compareVersion(v1, v2));
    }
}
