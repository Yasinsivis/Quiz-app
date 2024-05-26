package com.example.luno;

public class Questions {

       private int id;
        private String questionText;
        private String optionA;
        private String optionB;
        private String optionC;
        private String optionD;
        private String correctOption;
        private int points;
        private String hint;

        public Questions(int id , String optionA, String optionB, String optionC, String optionD, String correctOption, int points, String hint) {
            this.id = id;
            this.questionText = questionText;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.correctOption = correctOption;
            this.points = points;
            this.hint = hint;
        }

        // Getter ve setter metodları
        public int getId() { return id; }
        public String getQuestionText() { return questionText; }
        public String getOptionA() { return optionA; }
        public String getOptionB() { return optionB; }
        public String getOptionC() { return optionC; }
        public String getOptionD() { return optionD; }
        public String getCorrectOption() { return correctOption; }
        public int getPoints() { return points; }
        public String getHint() { return hint; }


}