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
    

if __name__ == "__main__":

    a = AdministradorUsuarioFactory()
    v = VisitanteUsuarioFactory()
    b = BeneficiarioUsuarioFactory()



