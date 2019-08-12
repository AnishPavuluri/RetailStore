create table RS_USER
(
  ID      			NUMBER(38) GENERATED BY DEFAULT ON NULL AS IDENTITY,
  NAME     			VARCHAR2(100 CHAR),
  EMAIL_ID      	VARCHAR2(100 CHAR),
  PASSWORD          VARCHAR2(100 CHAR),
  USER_TYPE         VARCHAR2(100 CHAR),
  CREATED_DATE      DATE,
  OPTLOCK_VERSION	NUMBER(10),
  LAST_UPDATED_BY   VARCHAR2(100 CHAR),
  LAST_UPDATED      DATE default SYSDATE not null,
  CONSTRAINT RS_USER_PK PRIMARY KEY (ID)
)

create table RS_ITEM
(
  ID      			NUMBER(38) GENERATED BY DEFAULT ON NULL AS IDENTITY,
  ITEM_NAME     	VARCHAR2(100 CHAR),
  PRICE      	    NUMBER(10,2),
  IS_GROCERY        NUMBER(1),
  OPTLOCK_VERSION	NUMBER(10),
  LAST_UPDATED_BY   VARCHAR2(100 CHAR),
  LAST_UPDATED      DATE default SYSDATE not null,
  CONSTRAINT RS_ITEM_PK PRIMARY KEY (ID)
)

create table RS_CART
(
  ID      			NUMBER(38) GENERATED BY DEFAULT ON NULL AS IDENTITY,
  USER_ID     	    NUMBER(38),
  TOTAL_PRICE      	NUMBER(10,2),
  OPTLOCK_VERSION	NUMBER(10),
  LAST_UPDATED_BY   VARCHAR2(100 CHAR),
  LAST_UPDATED      DATE default SYSDATE not null,
  CONSTRAINT RS_CART_PK PRIMARY KEY (ID)
)

create table RS_ORDER
(
  ID      			NUMBER(38) GENERATED BY DEFAULT ON NULL AS IDENTITY,
  ITEM_ID     	    NUMBER(38),
  QUANTITY      	NUMBER(3),
  CART_ID	        NUMBER(38),
  OPTLOCK_VERSION	NUMBER(10),
  LAST_UPDATED_BY   VARCHAR2(100 CHAR),
  LAST_UPDATED      DATE default SYSDATE not null,
  CONSTRAINT RS_ORDER_PK PRIMARY KEY (ID)
)