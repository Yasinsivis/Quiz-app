CREATE TABLE ANSWER(
ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
NAME VARCHAR(30)
);

CREATE TABLE "USER"
(
PLAYER_ID INT,
ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
NAME varchar(30) NOT NULL,
PASSWORD varchar(15) NOT NULL
);


CREATE TABLE PLAYER
(
ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
USER_ID INT,
NAME varchar(50),
SCORE INT DEFAULT 0,
MONTHLY_SCORE INT DEFAULT 0,
CONSTRAINT PLAYER_FK_1 FOREIGN KEY(USER_ID) REFERENCES "USER" (ID)
);

CREATE TABLE ENGLISH_WORD
(
ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
NAME varchar(30)
);

CREATE TABLE QUESTION
(
ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
CLUE varchar(50),
POINT INT,
ANSWER_ID_1 INT,
ANSWER_ID_2 INT,
ANSWER_ID_3 INT,
ANSWER_ID_4 INT,
CORRECT_ANSWER_ID INT,
ENGLISH_WORD_ID INT, /*�ngilizce Soru */
CONSTRAINT QUESTION_FK_1 FOREIGN KEY(ENGLISH_WORD_ID) references ENGLISH_WORD (ID),
CONSTRAINT QUESTION_FK_2 FOREIGN KEY (ANSWER_ID_1) references ANSWER (ID),
CONSTRAINT QUESTION_FK_3 FOREIGN KEY (ANSWER_ID_2) references ANSWER (ID),
CONSTRAINT QUESTION_FK_4 FOREIGN KEY (ANSWER_ID_3) references ANSWER (ID),
CONSTRAINT QUESTION_FK_5 FOREIGN KEY (ANSWER_ID_4) references ANSWER (ID),
CONSTRAINT QUESTION_FK_6 FOREIGN KEY (CORRECT_ANSWER_ID) references ANSWER (ID)
);
ALTER TABLE "USER" ADD CONSTRAINT USER_FK_1 FOREIGN KEY(PLAYER_ID) REFERENCES PLAYER (ID)




