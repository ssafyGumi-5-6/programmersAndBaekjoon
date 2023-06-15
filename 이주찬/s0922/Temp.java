public class Temp {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int year = 2010;
        int month = 1;
        int day = 1;
        for (int i = 0; i < 666; i++) {
            day++;
            if(month == 2 && year % 4 == 0) {
                if (day == 29) {
                    month++;
                    day = 1;
                }
            }else if(month == 2) {
                if(day == 30) {
                    month++;
                    day = 1;
                }
            }else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
                    || month == 12) {
                if (day == 32) {
                    month++;
                    day = 1;
                }
            } else {
                if (day == 31) {
                    month++;
                    day = 1;
                }
            }
            if (month == 13) {
                year++;
                month = 1;
            }
        }
        System.out.println("" + year + month + day);
    }
}