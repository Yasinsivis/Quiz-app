package com.example.luno;

public class Questions {

        private int id;
        private String optionA;
        private String optionB;
        private String optionC;
        private String optionD;
        private String correctOption;
        private int points;
        private String hint;

        public Questions(int id  ,String optionA, String optionB, String optionC, String optionD, String correctOption, int points, String hint) {
            this.id = id;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.correctOption = correctOption;
            this.points = points;
            this.hint = hint;
        }


        public int getId() { return id; }

        public String getOptionA() { return optionA; }
        public String getOptionB() { return optionB; }
        public String getOptionC() { return optionC; }
        public String getOptionD() { return optionD; }

        public int getPoints() { return points; }
        public String getHint() { return hint; }


}
