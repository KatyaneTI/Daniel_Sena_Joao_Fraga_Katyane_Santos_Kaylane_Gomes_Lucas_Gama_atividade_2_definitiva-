CREATE TABLE CHAT (
  id_chat int NOT NULL,
  Data date,
  Hora timestamp,
  PRIMARY KEY (id_chat)
  foreign KEY (id_visitante) references VISITANTE(id_visitante),
  union KEY id_visitante(id_visitante)
);

CREATE TABLE CIDADAO (
  id_cidadao int NOT NULL,
  PRIMARY KEY (id_cidadao),
  foreign KEY (id_beneficiario) references BENEFICIARIO(id_beneficiario),
  union KEY id_cidadao(id_cidadao)
);

CREATE TABLE RELATORIO (
  id_relatorio int NOT NULL,
  Data date,
  Tipo varchar(45),
  PRIMARY KEY (id_relatorio),
  foreign KEY (id_beneficiario) references BENEFICIARIO(id_beneficiario),
  union KEY id_cidadao(id_cidadao)
);

CREATE TABLE CONCESSAO (
  id_concessao int NOT NULL,
  Data date,
  Status varchar(45),
  Tipo varchar(45),
  Cid varchar(45),
  PRIMARY KEY (id_concessao)
  foreign KEY (id_cidadao) references CIDADAO(id_cidadao),
  union KEY id_cidadao(id_cidadao)
);

CREATE TABLE BENEFICIO (
  id_beneficio int NOT NULL,
  Ano int,
  Data_nascimento date,
  Sexo varchar(10),
  Municipio varchar(45),
  Estado varchar(20),
  PRIMARY KEY (id_beneficio)
  foreign KEY (id_beneficiario) references BENEFICIARIO(id_beneficiario),
  union KEY id_cidadao(id_cidadao)
);

CREATE TABLE ESTATISTICA (
  id_estatistica int NOT NULL,
  Data date,
  Tipo varchar(45),
  PRIMARY KEY (id_estatistica),
  foreign KEY (id_beneficiario) references BENEFICIARIO(id_beneficiario),
  union KEY id_cidadao(id_cidadao)
);

CREATE TABLE NOTIFICACAO (
  id_notificacao int NOT NULL,
  mensagen varchar(45),
  Data_envio date,
  PRIMARY KEY (id_notificacao),
  foreign KEY (id_beneficiario) references BENEFICIARIO(id_beneficiario),
  union KEY id_cidadao(id_cidadao)
);

CREATE TABLE BENEFICIARIO (
  id_beneficiario int NOT NULL,
  Nome int,
  Data_nascimento date,
  CPF varchar(15),
  Email varchar(45),
  PRIMARY KEY (id_notificacao)
  foreign KEY (id_concessao) references CONCESSAO(id_concessao),
  union KEY id_beneficiario(id_beneficiario)
);

CREATE TABLE VISITANTE (
  id_visitante int NOT NULL,
   PRIMARY KEY (id_visitante)
);

CREATE TABLE ADIMINISTRADOR (
  Cargo varchar(45),
  Usuario varchar(45),
  Senha varchar(45),
  Historico varchar(50),
  PRIMARY KEY (Cargo),]
  foreign KEY (id_cidadao) references CIDADAO(id_cidadao),
  union KEY id_cidadao(id_cidadao)
);


