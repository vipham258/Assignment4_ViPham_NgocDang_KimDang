---------add create date, update date for this----
CREATE TABLE PORTFOLIO (
    PORTFOLIO_ID INT IDENTITY not null,
    BALANCE DOUBLE,
    VERSION INTEGER,    
    CREATED_DATE DATE,
    UPDATED_DATE DATE,
    PRIMARY KEY (PORTFOLIO_ID)
);
CREATE TABLE ACCOUNT (
    ACCOUNT_ID INT IDENTITY not null,
    ACCOUNT_TYPE CHARACTER(1),
    BALANCE DOUBLE,
    VERSION INTEGER,
    PORTFOLIO_ID INTEGER,
    CREATED_DATE DATE,
    UPDATED_DATE DATE,
    PRIMARY KEY (ACCOUNT_ID)
);
ALTER TABLE ACCOUNT ADD CONSTRAINT ACCNT_PFOLIO_FK  FOREIGN KEY(PORTFOLIO_ID) REFERENCES PORTFOLIO(PORTFOLIO_ID);

--------
CREATE TABLE ASSET (
    ASSET_ID INT IDENTITY not null,
    PORTFOLIO_ID INTEGER,
    ASSET_NAME VARCHAR,
    UNITS INTEGER,
    PRICE DOUBLE,
    CURRENT_VALUE DOUBLE,
    CREATED_DATE DATE,
    UPDATED_DATE DATE,
    PRIMARY KEY (ASSET_ID)
);

ALTER TABLE ASSET ADD CONSTRAINT ASSET_PFOLIO_FK FOREIGN KEY(PORTFOLIO_ID) REFERENCES PORTFOLIO(PORTFOLIO_ID);


CREATE TABLE USER_ACCOUNT (
    USER_ID INT IDENTITY not null,
    CREATED_DATE DATE,
    UPDATED_DATE DATE,
    PRIMARY KEY (USER_ID)
);

CREATE TABLE USER_ACCOUNT_ACCOUNT (
    USER_ID INT IDENTITY not null,
    ACCOUNT_ID INTEGER not null,
);

ALTER TABLE USER_ACCOUNT_ACCOUNT ADD CONSTRAINT FK1 FOREIGN KEY(ACCOUNT_ID) REFERENCES ACCOUNT(ACCOUNT_ID);
ALTER TABLE USER_ACCOUNT_ACCOUNT ADD CONSTRAINT FK2 FOREIGN KEY(USER_ID) REFERENCES USER_ACCOUNT(USER_ID);

ALTER TABLE ACCOUNT ADD RATE DOUBLE,CREATED_DATE DATE,
    UPDATED_DATE DATE;


CREATE TABLE PLATFORM_ROLE (
    ID INT IDENTITY not null,
    ROLE_NAME VARCHAR,
    CREATED_DATE DATE,
    UPDATED_DATE DATE,
    PRIMARY KEY (ID)
);

CREATE TABLE PLATFORM_USER (
    ID INT IDENTITY not null,
    USER_NAME VARCHAR,
    PWHASH VARCHAR,
    CREATED_DATE DATE,
    UPDATED_DATE DATE,
    PRIMARY KEY (ID)
);


CREATE TABLE PLATFORM_USER_PLATFORM_ROLE (
    USER_ID INTEGER not null,
    ROLE_ID INTEGER not null,
);
ALTER TABLE PLATFORM_USER_PLATFORM_ROLE ADD CONSTRAINT FK3 FOREIGN KEY(USER_ID) REFERENCES PLATFORM_USER(ID);
ALTER TABLE PLATFORM_USER_PLATFORM_ROLE ADD CONSTRAINT FK4 FOREIGN KEY(ROLE_ID) REFERENCES PLATFORM_ROLE(ID);


ALTER TABLE PLATFORM_USER ADD VERSION INTEGER;
ALTER TABLE PLATFORM_USER ADD BANKING_USER_ID INTEGER;
ALTER TABLE PLATFORM_USER ADD CONSTRAINT PLATFORM_USER_USER_FK FOREIGN KEY(BANKING_USER_ID) REFERENCES USER_ACCOUNT(USER_ID);

ALTER TABLE USER_ACCOUNT ADD NAME VARCHAR;
ALTER TABLE PLATFORM_ROLE ADD VERSION INTEGER;
ALTER TABLE USER_ACCOUNT ADD VERSION INTEGER;
ALTER TABLE ASSET ADD VERSION INTEGER;