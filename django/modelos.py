from django.db import models

class Chat(models.Model):
    id_chat = models.IntegerField(primary_key=True)
    data = models.DateField()
    hora = models.TimeField()

class Usuario(models.Model):
    nome_completo = models.CharField(max_length=100)
    data_nascimento = models.DateField()
    email = models.EmailField()
    cpf = models.CharField(max_length=15)
    papel = models.CharField(max_length=40) 

class Cidadao(models.Model):
    id_cidadao = models.IntegerField(primary_key=True)

class Beneficiario(models.Model):
    id_beneficiario = models.IntegerField(primary_key=True)
    nome = models.CharField(max_length=100)
    data_nascimento = models.DateField()
    cpf = models.CharField(max_length=15)
    email = models.EmailField()

class Visitante(models.Model):
    id_visitante = models.IntegerField(primary_key=True)

class Administrador(models.Model):
    cargo = models.CharField(max_length=45, primary_key=True)
    usuario = models.CharField(max_length=45)
    senha = models.CharField(max_length=45)
    historico = models.CharField(max_length=50)

class Relatorio(models.Model):
    id_relatorio = models.IntegerField(primary_key=True)
    data = models.DateField()
    tipo = models.CharField(max_length=45)

class Concessao(models.Model):
    id_concessao = models.IntegerField(primary_key=True)
    data = models.DateField()
    status = models.CharField(max_length=45)
    tipo = models.CharField(max_length=45)
    cid = models.CharField(max_length=45)

class Beneficio(models.Model):
    id_beneficio = models.IntegerField(primary_key=True)
    ano = models.IntegerField()
    data_nascimento = models.DateField()
    sexo = models.CharField(max_length=10)
    municipio = models.CharField(max_length=45)
    estado = models.CharField(max_length=20)

class Estatistica(models.Model):
    id_estatistica = models.IntegerField(primary_key=True)
    data = models.DateField()
    tipo = models.CharField(max_length=45)

class Notificacao(models.Model):
    id_notificacao = models.IntegerField(primary_key=True)
    mensagem = models.CharField(max_length=45)
    data_envio = models.DateField()
