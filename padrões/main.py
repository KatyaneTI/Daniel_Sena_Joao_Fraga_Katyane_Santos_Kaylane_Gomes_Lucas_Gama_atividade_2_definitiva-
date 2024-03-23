from abc import ABC, abstractmethod

class Usuario(ABC):

    @abstractmethod
    def usario(self):

        pass
    
class Administrador(Usuario):
    def __init__(self):
        {

        }

class Visitante(Usuario):
    def __init__(self):
        {

        }

class Benificiario(Usuario):
    def __init__(self):
        {

        }


class UsuarioFactory(ABC):
    @abstractmethod
    def create_usuario(self):
        pass
    
class AdministradorUsuarioFactory(UsuarioFactory):
    def create_usuario(self):
        return super().create_usuario()
    
class VisitanteUsuarioFactory(UsuarioFactory):
    def create_usuario(self):
        return super().create_usuario()

class BeneficiarioUsuarioFactory(UsuarioFactory):
    def create_usuario(self):
        return super().create_usuario()
class Beneficio:
    def baixar_beneficios(self):{

    }

    def visualizar_beneficios(self):{

    }

class Relatorio:
    def gerar_relatorios(self):{

    }

class Estatistica:
    def gerar_estatisticas(self):{

    }      

class Chat:
    def tirar_duvidas(self):{

    }

class UsuarioFacade:
    def __init__(self):
        self.beneficios = Beneficio()
        self.relatorios = Relatorio()
        self.estatisticas = Estatistica()
        self.chat = Chat()

    def start(self):
       
        beneficios_baixados = self.beneficios.baixar_beneficios()
        beneficios_visualizados = self.beneficios.visualizar_beneficios()
        relatorio = self.relatorios.gerar_relatorios()
        estatisticas = self.estatisticas.gerar_estatisticas()
        chat = self.chat.tirar_duvidas()  

if __name__ == "__main__":

    a = AdministradorUsuarioFactory()
    v = VisitanteUsuarioFactory()
    b = BeneficiarioUsuarioFactory()
    usuario = UsuarioFacade()