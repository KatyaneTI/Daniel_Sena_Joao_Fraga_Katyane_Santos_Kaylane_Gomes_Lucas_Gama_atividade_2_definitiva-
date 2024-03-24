from django.urls import path
from .views import (
    ChatListView, ChatCreateView, ChatUpdateView, ChatDeleteView,
    UsuarioListView, UsuarioCreateView, UsuarioUpdateView, UsuarioDeleteView,
    BeneficiarioListView,  BeneficiarioCreateView, BeneficiarioUpdateView, BeneficiarioDeleteView,
    VisitanteListView, VisitanteCreateView, VisitanteUpdateView, VisitanteDeleteView,
    AdministradorListView, AdministradorCreateView, AdministradorUpdateView, AdministradorDeleteView,
    RelatorioListView, RelatorioCreateView, RelatorioUpdateView, RelatorioDeleteView,
    ConcessaoListView, ConcessaoCreateView, ConcessaoUpdateView, ConcessaoDeleteView,
    BeneficioListView, BeneficioCreateView, BeneficioUpdateView, BeneficioDeleteView,
    EstatisticaListView, EstatisticaCreateView, EstatisticaUpdateView, EstatisticaDeleteView,
    NotificacaoListView, NotificacaoCreateView, NotificacaoUpdateView, NotificacaoDeleteView,
)

urlpatterns = [
   
    path('chat/', ChatListView.as_view(), name='chat_list'),
    path('chat/create/', ChatCreateView.as_view(), name='chat_create'),
    path('chat/<int:pk>/update/', ChatUpdateView.as_view(), name='chat_update'),
    path('chat/<int:pk>/delete/', ChatDeleteView.as_view(), name='chat_delete'),

  
    path('usuario/', UsuarioListView.as_view(), name='usuario_list'),
    path('usuario/create/', UsuarioCreateView.as_view(), name='usuario_create'),
    path('usuario/<int:pk>/update/', UsuarioUpdateView.as_view(), name='usuario_update'),
    path('usuario/<int:pk>/delete/', UsuarioDeleteView.as_view(), name='usuario_delete'),

    path('beneficiario/', BeneficiarioListView.as_view(), name='beneficiario_list'),
    path('beneficiario/create/', BeneficiarioCreateView.as_view(), name='beneficiario_create'),
    path('beneficiario/<int:pk>/update/', BeneficiarioUpdateView.as_view(), name='beneficiario_update'),
    path('beneficiario/<int:pk>/delete/', BeneficiarioDeleteView.as_view(), name='beneficiario_delete'),

    
    path('visitante/', VisitanteListView.as_view(), name='visitante_list'),
    path('visitante/create/', VisitanteCreateView.as_view(), name='visitante_create'),
    path('visitante/<int:pk>/update/', VisitanteUpdateView.as_view(), name='visitante_update'),
    path('visitante/<int:pk>/delete/', VisitanteDeleteView.as_view(), name='visitante_delete'),

    
    path('administrador/', AdministradorListView.as_view(), name='administrador_list'),
    path('administrador/create/', AdministradorCreateView.as_view(), name='administrador_create'),
    path('administrador/<str:pk>/update/', AdministradorUpdateView.as_view(), name='administrador_update'),
    path('administrador/<str:pk>/delete/', AdministradorDeleteView.as_view(), name='administrador_delete'),

    path('relatorio/', RelatorioListView.as_view(), name='relatorio_list'),
    path('relatorio/create/', RelatorioCreateView.as_view(), name='relatorio_create'),
    path('relatorio/<int:pk>/update/', RelatorioUpdateView.as_view(), name='relatorio_update'),
    path('relatorio/<int:pk>/delete/', RelatorioDeleteView.as_view(), name='relatorio_delete'),

   
    path('concessao/', ConcessaoListView.as_view(), name='concessao_list'),
    path('concessao/create/', ConcessaoCreateView.as_view(), name='concessao_create'),
    path('concessao/<int:pk>/update/', ConcessaoUpdateView.as_view(), name='concessao_update'),
    path('concessao/<int:pk>/delete/', ConcessaoDeleteView.as_view(), name='concessao_delete'),

    
    path('beneficio/', BeneficioListView.as_view(), name='beneficio_list'),
    path('beneficio/create/', BeneficioCreateView.as_view(), name='beneficio_create'),
    path('beneficio/<int:pk>/update/', BeneficioUpdateView.as_view(), name='beneficio_update'),
    path('beneficio/<int:pk>/delete/', BeneficioDeleteView.as_view(), name='beneficio_delete'),

   
    path('estatistica/', EstatisticaListView.as_view(), name='estatistica_list'),
    path('estatistica/create/', EstatisticaCreateView.as_view(), name='estatistica_create'),
    path('estatistica/<int:pk>/update/', EstatisticaUpdateView.as_view(), name='estatistica_update'),
    path('estatistica/<int:pk>/delete/', EstatisticaDeleteView.as_view(), name='estatistica_delete'),

    path('notificacao/', NotificacaoListView.as_view(), name='notificacao_list'),
    path('notificacao/create/', NotificacaoCreateView.as_view(), name='notificacao_create'),
    path('notificacao/<int:pk>/update/', NotificacaoUpdateView.as_view(), name='notificacao_update'),
    path('notificacao/<int:pk>/delete/', NotificacaoDeleteView.as_view(), name='notificacao_delete'),

]