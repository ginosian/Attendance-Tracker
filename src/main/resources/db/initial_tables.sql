create table auth_access_token
(
  id          varchar(100)          not null
    constraint auth_access_token_pkey
    primary key,
  created     timestamp,
  deleted     boolean default false not null,
  updated     timestamp,
  description varchar(255),
  token       varchar(255),
  user_id     varchar(100)          not null
    constraint uk_gea2l9f5x31c3vdwy7wvvbm6l
    unique
);

alter table auth_access_token
  owner to postgres;

create table company
(
  id                      varchar(100)          not null
    constraint company_pkey
    primary key
    constraint uk_qdo38t35lgbgluwtbfej64u3d
    unique,
  created                 timestamp,
  deleted                 boolean default false not null,
  updated                 timestamp,
  non_expired             boolean,
  non_locked              boolean,
  approved                boolean,
  credentials_non_expired boolean,
  enabled                 boolean,
  email                   varchar(255)          not null
    constraint uk_bma9lv19ba3yjwf12a34xord3
    unique,
  name                    varchar(255)          not null
    constraint uk_niu8sfil2gxywcru9ah3r4ec5
    unique
);

alter table company
  owner to postgres;

create table employee
(
  id                      varchar(100)          not null
    constraint employee_pkey
    primary key
    constraint uk_nhli7owi6ferubmgll5umph0
    unique,
  created                 timestamp,
  deleted                 boolean default false not null,
  updated                 timestamp,
  non_expired             boolean,
  non_locked              boolean,
  approved                boolean,
  credentials_non_expired boolean,
  enabled                 boolean,
  email                   varchar(255)          not null
    constraint uk_fopic1oh5oln2khj8eat6ino0
    unique,
  first_name              varchar(255),
  joining_date            timestamp,
  last_name               varchar(255),
  leaving_date            timestamp,
  phone                   varchar(255)
    constraint uk_buf2qp04xpwfp5qq355706h4a
    unique,
  company_id              varchar(100)
    constraint "FKpsv0ahqx9r3w0di68ssy0696t"
    references company
);

alter table employee
  owner to postgres;

create table owner
(
  id                      varchar(100)          not null
    constraint owner_pkey
    primary key
    constraint uk_l2uk64jwftc10ottfl649gr59
    unique,
  created                 timestamp,
  deleted                 boolean default false not null,
  updated                 timestamp,
  non_expired             boolean,
  non_locked              boolean,
  approved                boolean,
  credentials_non_expired boolean,
  enabled                 boolean,
  email                   varchar(255)          not null
    constraint uk_kcaoebbgb82ro5cw9nqhw19qb
    unique,
  first_name              varchar(255),
  last_name               varchar(255),
  phone                   varchar(255)
    constraint uk_q3nfx0w9lmfnyeepg23ccenhu
    unique
);

alter table owner
  owner to postgres;

create table permission
(
  id      varchar(100)          not null
    constraint permission_pkey
    primary key,
  created timestamp,
  deleted boolean default false not null,
  updated timestamp,
  type    varchar(255)          not null
    constraint uk_33jpqqwn84csps080lotp9tue
    unique
);

alter table permission
  owner to postgres;

create table policy
(
  "DTYPE"                              varchar(31)           not null,
  id                                   varchar(100)          not null
    constraint policy_pkey
    primary key,
  created                              timestamp,
  deleted                              boolean default false not null,
  updated                              timestamp,
  attendance_calculation_type          varchar(255),
  working_days_week                    integer,
  working_hours_day                    integer,
  working_hours_week                   integer,
  register_as_vacation_immediate       boolean,
  time_off_min_duration                varchar(255),
  vacation_per_day                     integer,
  vacation_per_month                   integer,
  vacation_per_week                    integer,
  vacation_per_year                    integer,
  individual_attendance_policy_active  boolean,
  individual_time_off_poli_active      boolean,
  "individual_vacation_policy_aActive" boolean,
  company_id                           varchar(100)
    constraint "FKrb3h2ert8ltfq7hm5tp3me8eb"
    references company,
  employee_id                          varchar(100)
    constraint "FKmb2tfrtapv9em2qpi70k8973n"
    references employee
);

alter table policy
  owner to postgres;

create table company_details
(
  id         varchar(100)          not null
    constraint company_details_pkey
    primary key,
  created    timestamp,
  deleted    boolean default false not null,
  updated    timestamp,
  company_id varchar(100)          not null
    constraint uk_cpfobl3rf6wogmbobv69lfec1
    unique
    constraint "FKplwy6xv0ce8a8pawkqr010xqs"
    references company,
  policy_id  varchar(100)
    constraint "FKf92euvulphrokvm848tqy1dow"
    references policy
);

alter table company_details
  owner to postgres;

create table company_details_policy
(
  "CompanyDetails_id"     varchar(100) not null
    constraint "FK4r85qy9wfy575dqh789cf3sle"
    references company_details,
  "individualPolicies_id" varchar(100) not null
    constraint uk_o2p7j8xcpmbybcwoykplxwl5q
    unique
    constraint "FK1tybjmc5opmldw1subygocwpj"
    references policy,
  constraint company_details_policy_pkey
  primary key ("CompanyDetails_id", "individualPolicies_id")
);

alter table company_details_policy
  owner to postgres;

create table role
(
  id      varchar(100)          not null
    constraint role_pkey
    primary key,
  created timestamp,
  deleted boolean default false not null,
  updated timestamp,
  type    varchar(255)          not null
    constraint uk_93vn3jeavtylq20tjdx2p2kkd
    unique
);

alter table role
  owner to postgres;

create table role_permission
(
  role_id       varchar(100) not null
    constraint "FKp9q4vdsx41116ra1enydewgre"
    references role,
  permission_id varchar(100) not null
    constraint "FK28fyyigl7pt1rfdf7o736vxe"
    references permission,
  constraint role_permission_pkey
  primary key (role_id, permission_id)
);

alter table role_permission
  owner to postgres;

create table "user"
(
  id                      varchar(100)          not null
    constraint user_pkey
    primary key,
  created                 timestamp,
  deleted                 boolean default false not null,
  updated                 timestamp,
  non_expired             boolean,
  non_locked              boolean,
  approved                boolean,
  credentials_non_expired boolean,
  enabled                 boolean
);

alter table "user"
  owner to postgres;

create table user_details
(
  id            varchar(100)          not null
    constraint user_details_pkey
    primary key,
  created       timestamp,
  deleted       boolean default false not null,
  updated       timestamp,
  password_hash varchar(255)          not null,
  username      varchar(255)          not null,
  creator_id    varchar(100)          not null
    constraint uk_a2c1bbh2flu2ctbroo8xxfcyi
    unique
    constraint "FK6u9ff0m1nv4sqxr1seowd8v3c"
    references owner
);

alter table user_details
  owner to postgres;

create table user_role
(
  user_id varchar(100) not null
    constraint "FK716yl6flwfac5noxqs3uxl1to"
    references user_details,
  role_id varchar(100) not null
    constraint "FKka3w3atry4amefp94rblb52n7"
    references role,
  constraint user_role_pkey
  primary key (user_id, role_id)
);

alter table user_role
  owner to postgres;
