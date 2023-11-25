DROP TABLE items IF EXISTS;
DROP TABLE users IF EXISTS;

CREATE TABLE items (
  id         INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  name VARCHAR(30)
);

CREATE TABLE users (
  id         INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  name       VARCHAR(30)
);