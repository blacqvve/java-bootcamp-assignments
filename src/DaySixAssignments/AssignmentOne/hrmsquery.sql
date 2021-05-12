-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public."Users"
(
    "Email" character varying(50) NOT NULL,
    "Id" integer NOT NULL,
    "Password" character varying(50) NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE public."JobSeekers"
(
    "UserId" integer NOT NULL,
    "Name" character varying(50) NOT NULL,
    "Surname" character varying(50) NOT NULL,
    "DateOfBirth" date NOT NULL,
    "NationalIdentityNumber" character varying(11) NOT NULL,
    "ConfirmationId" integer NOT NULL,
    "JobTitleId" integer,
    PRIMARY KEY ("UserId")
);

CREATE TABLE public."JobPosters"
(
    "UserId" integer NOT NULL,
    "Name" character varying(50) NOT NULL,
    "Website" character varying(50) NOT NULL,
    "Email" character varying(50) NOT NULL,
    "Phone" character varying(15) NOT NULL,
    "ConfirmationId" integer NOT NULL,
    PRIMARY KEY ("UserId")
);

CREATE TABLE public."SystemUser"
(
    "UserId" integer NOT NULL,
    "Name" character varying(50),
    "Surname" character varying(50),
    PRIMARY KEY ("UserId")
);

CREATE TABLE public."Confirmation"
(
    "Id" integer NOT NULL,
    "Confirmed" boolean NOT NULL,
    "ConfirmationDate" date NOT NULL,
    PRIMARY KEY ("Id")
);

CREATE TABLE public."EmailConfirmation"
(
    "ConfirmationId" integer NOT NULL,
    "ConfirmationToken" character varying(120) NOT NULL,
    PRIMARY KEY ("ConfirmationId")
);

CREATE TABLE public."UserConfirmation"
(
    "ConfirmationId" integer NOT NULL,
    "ValidatorUser" integer NOT NULL,
    PRIMARY KEY ("ConfirmationId")
);

CREATE TABLE public."JobTitles"
(
    "Id" integer NOT NULL,
    "Title" character varying(50) NOT NULL,
    PRIMARY KEY ("Id")
);

ALTER TABLE public."JobSeekers"
    ADD FOREIGN KEY ("UserId")
    REFERENCES public."Users" ("Id")
    NOT VALID;


ALTER TABLE public."SystemUser"
    ADD FOREIGN KEY ("UserId")
    REFERENCES public."Users" ("Id")
    NOT VALID;


ALTER TABLE public."JobPosters"
    ADD FOREIGN KEY ("UserId")
    REFERENCES public."Users" ("Id")
    NOT VALID;


ALTER TABLE public."EmailConfirmation"
    ADD FOREIGN KEY ("ConfirmationId")
    REFERENCES public."Confirmation" ("Id")
    NOT VALID;


ALTER TABLE public."JobPosters"
    ADD FOREIGN KEY ("ConfirmationId")
    REFERENCES public."Confirmation" ("Id")
    NOT VALID;


ALTER TABLE public."JobSeekers"
    ADD FOREIGN KEY ("ConfirmationId")
    REFERENCES public."Confirmation" ("Id")
    NOT VALID;


ALTER TABLE public."UserConfirmation"
    ADD FOREIGN KEY ("ConfirmationId")
    REFERENCES public."Confirmation" ("Id")
    NOT VALID;


ALTER TABLE public."UserConfirmation"
    ADD FOREIGN KEY ("ValidatorUser")
    REFERENCES public."Users" ("Id")
    NOT VALID;


ALTER TABLE public."JobSeekers"
    ADD FOREIGN KEY ("JobTitleId")
    REFERENCES public."JobTitles" ("Id")
    NOT VALID;

END;