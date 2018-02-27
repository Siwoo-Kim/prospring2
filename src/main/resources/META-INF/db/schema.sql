CREATE TABLE SINGER (
    ID INT NOT NULL AUTO_INCREMENT
  , FIRST_NAME VARCHAR(60) NOT NULL
  , LAST_NAME VARCHAR(40) NOT NULL
  , BIRTH_DATE DATE
  , VERSION INT NOT NULL DEFAULT 0
  , UNIQUE UQ_SINGER_1 (FIRST_NAME, LAST_NAME)
  , PRIMARY KEY (ID)
);

CREATE TABLE ALBUM (
    ID INT NOT NULL AUTO_INCREMENT
  , SINGER_ID INT NOT NULL
  , TITLE VARCHAR(100) NOT NULL
  , RELEASE_DATE DATE
  , VERSION INT NOT NULL DEFAULT 0
  , UNIQUE UQ_SINGER_ALBUM_1 (SINGER_ID, TITLE)
  , PRIMARY KEY (ID)
  , CONSTRAINT FK_ALBUM_SINGER FOREIGN KEY (SINGER_ID)
REFERENCES SINGER (ID)
);


CREATE TABLE INSTRUMENT (
  INSTRUMENT_ID VARCHAR(20) NOT NULL
  , PRIMARY KEY (INSTRUMENT_ID)
);

CREATE TABLE SINGER_INSTRUMENT (
    SINGER_ID INT NOT NULL
  , INSTRUMENT_ID VARCHAR(20) NOT NULL
  , PRIMARY KEY (SINGER_ID, INSTRUMENT_ID)
  , CONSTRAINT FK_SINGER_INSTRUMENT_1 FOREIGN KEY (SINGER_ID)
REFERENCES SINGER (ID) ON DELETE CASCADE
  , CONSTRAINT FK_SINGER_INSTRUMENT_2 FOREIGN KEY (INSTRUMENT_ID)
REFERENCES INSTRUMENT (INSTRUMENT_ID)
);

CREATE TABLE SINGER_AUDIT (
    ID INT NOT NULL AUTO_INCREMENT
  , FIRST_NAME VARCHAR(60) NOT NULL
  , LAST_NAME VARCHAR(40) NOT NULL
  , BIRTH_DATE DATE
  , VERSION INT NOT NULL DEFAULT 0
  , CREATED_BY VARCHAR(20)
  , CREATED_DATE TIMESTAMP
  , LAST_MODIFIED_BY VARCHAR(20)
  , LAST_MODIFIED_DATE TIMESTAMP
  , UNIQUE UQ_SINGER_AUDIT_1 (FIRST_NAME, LAST_NAME)
  , PRIMARY KEY (ID)
);


CREATE TABLE SINGER_AUDIT_H (
    ID INT NOT NULL AUTO_INCREMENT
  , FIRST_NAME VARCHAR(60) NOT NULL
  , LAST_NAME VARCHAR(40) NOT NULL
  , BIRTH_DATE DATE
  , VERSION INT NOT NULL DEFAULT 0
  , CREATED_BY VARCHAR(20)
  , CREATED_DATE TIMESTAMP
  , LAST_MODIFIED_BY VARCHAR(20)
  , LAST_MODIFIED_DATE TIMESTAMP
  , AUDIT_REVISION INT NOT NULL
  , ACTION_TYPE INT
  , AUDIT_REVISION_END INT
  , AUDIT_REVISION_END_TS TIMESTAMP
  , UNIQUE UQ_SINGER_AUDIT_H_1 (FIRST_NAME, LAST_NAME)
  , PRIMARY KEY (ID, AUDIT_REVISION)
);

CREATE TABLE REVINFO (
    REVTSTMP BIGINT NOT NULL
    , REV INT NOT NULL AUTO_INCREMENT
    , PRIMARY KEY (REVTSTMP, REV)
);
