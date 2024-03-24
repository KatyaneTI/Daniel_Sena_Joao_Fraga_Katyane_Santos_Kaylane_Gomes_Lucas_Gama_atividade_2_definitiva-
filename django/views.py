from django.views.generic import ListView, CreateView, UpdateView, DeleteView
from django.urls import reverse_lazy
from django.shortcuts import get_object_or_404, redirect
from .models import Chat, Usuario, Beneficiario, Visitante, Administrador, Relatorio, Concessao, Beneficio, Estatistica, Notificacao

class ChatListView(ListView):
    model = Chat

class ChatCreateView(CreateView):
    model = Chat
    fields = ['data', 'hora']
    success_url = reverse_lazy('chat_list')

class ChatUpdateView(UpdateView):
    model = Chat
    fields = ['data', 'hora']
    success_url = reverse_lazy('chat_list')

class ChatDeleteView(DeleteView):
    model = Chat
    success_url = reverse_lazy('chat_list')

class UsuarioListView(ListView):
    model = Usuario

class UsuarioCreateView(CreateView):
    model = Usuario
    fields = ['id_usuario']
    success_url = reverse_lazy('usuario_list')

class UsuarioUpdateView(UpdateView):
    model = Usuario
    fields = ['id_usuario']
    success_url = reverse_lazy('usuario_list')

class UsuarioDeleteView(DeleteView):
    model = Usuario
    success_url = reverse_lazy('usuario_list')

class BeneficiarioListView(ListView):
    model = Beneficiario

class BeneficiarioCreateView(CreateView):
    model = Beneficiario
    fields = ['id_beneficiario', 'nome', 'data_nascimento', 'cpf', 'email']
    success_url = reverse_lazy('beneficiario_list')

class BeneficiarioUpdateView(UpdateView):
    model = Beneficiario
    fields = ['nome', 'data_nascimento', 'cpf', 'email']
    success_url = reverse_lazy('beneficiario_list')

class BeneficiarioDeleteView(DeleteView):
    model = Beneficiario
    success_url = reverse_lazy('beneficiario_list')

class VisitanteListView(ListView):
    model = Visitante

class VisitanteCreateView(CreateView):
    model = Visitante
    fields = ['id_visitante']
    success_url = reverse_lazy('visitante_list')

class VisitanteUpdateView(UpdateView):
    model = Visitante
    fields = ['id_visitante']
    success_url = reverse_lazy('visitante_list')

class VisitanteDeleteView(DeleteView):
    model = Visitante
    success_url = reverse_lazy('visitante_list')

class AdministradorListView(ListView):
    model = Administrador

class AdministradorCreateView(CreateView):
    model = Administrador
    fields = ['cargo', 'usuario', 'senha', 'historico']
    success_url = reverse_lazy('administrador_list')

class AdministradorUpdateView(UpdateView):
    model = Administrador
    fields = ['senha', 'historico']
    success_url = reverse_lazy('administrador_list')

class AdministradorDeleteView(DeleteView):
    model = Administrador
    success_url = reverse_lazy('administrador_list')

class RelatorioListView(ListView):
    model = Relatorio

class RelatorioCreateView(CreateView):
    model = Relatorio
    fields = ['data', 'tipo']
    success_url = reverse_lazy('relatorio_list')

class RelatorioUpdateView(UpdateView):
    model = Relatorio
    fields = ['data', 'tipo']
    success_url = reverse_lazy('relatorio_list')

class RelatorioDeleteView(DeleteView):
    model = Relatorio
    success_url = reverse_lazy('relatorio_list')

class ConcessaoListView(ListView):
    model = Concessao

class ConcessaoCreateView(CreateView):
    model = Concessao
    fields = ['data', 'status', 'tipo', 'cid']
    success_url = reverse_lazy('concessao_list')

class ConcessaoUpdateView(UpdateView):
    model = Concessao
    fields = ['data', 'status', 'tipo', 'cid']
    success_url = reverse_lazy('concessao_list')

class ConcessaoDeleteView(DeleteView):
    model = Concessao
    success_url = reverse_lazy('concessao_list')

class BeneficioListView(ListView):
    model = Beneficio

class BeneficioCreateView(CreateView):
    model = Beneficio
    fields = ['ano', 'data_nascimento', 'sexo', 'municipio', 'estado']
    success_url = reverse_lazy('beneficio_list')

class BeneficioUpdateView(UpdateView):
    model = Beneficio
    fields = ['ano', 'data_nascimento', 'sexo', 'municipio', 'estado']
    success_url = reverse_lazy('beneficio_list')

class BeneficioDeleteView(DeleteView):
    model = Beneficio
    success_url = reverse_lazy('beneficio_list')

class EstatisticaListView(ListView):
    model = Estatistica

class EstatisticaCreateView(CreateView):
    model = Estatistica
    fields = ['data', 'tipo']
    success_url = reverse_lazy('estatistica_list')

class EstatisticaUpdateView(UpdateView):
    model = Estatistica
    fields = ['data', 'tipo']
    success_url = reverse_lazy('estatistica_list')

class EstatisticaDeleteView(DeleteView):
    model = Estatistica
    success_url = reverse_lazy('estatistica_list')

class NotificacaoListView(ListView):
    model = Notificacao

class NotificacaoCreateView(CreateView):
    model = Notificacao
    fields = ['mensagem', 'data_envio']
    success_url = reverse_lazy('notificacao_list')

class NotificacaoUpdateView(UpdateView):
    model = Notificacao
    fields = ['mensagem', 'data_envio']
    success_url = reverse_lazy('notificacao_list')

class NotificacaoDeleteView(DeleteView):
    model = Notificacao
    success_url = reverse_lazy('notificacao_list')