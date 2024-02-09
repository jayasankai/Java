CREATE TABLE User (
  id BIGINT NOT NULL,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  create_date DATETIME(6),
  modified_date DATETIME(6),
  PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE User_seq (
  next_val BIGINT NOT NULL
) ENGINE=INNODB;

CREATE TABLE Item (
  id BIGINT,
  name VARCHAR(100),
  type VARCHAR(10),
  user_id BIGINT,
  INDEX user_id (user_id),
  FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
) ENGINE=INNODB;

CREATE TABLE Item_seq (
  next_val BIGINT NOT NULL
) ENGINE=INNODB;

