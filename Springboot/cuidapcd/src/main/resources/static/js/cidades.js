const cidadesPorEstado = {
    "Acre": ["Rio Branco", "Cruzeiro do Sul", "Senador Guiomard", "Plácido de Castro"],
    "Alagoas": ["Maceió", "Arapiraca", "Palmeira dos Índios", "Delmiro Gouveia"],
    "Amapá": ["Macapá", "Santana", "Laranjal do Jari", "Oiapoque"],
    "Amazonas": ["Manaus", "Parintins", "Itacoatiara", "Tabatinga"],
    "Bahia": ["Salvador", "Feira de Santana", "Vitória da Conquista", "Camaçari", "Guanambi"],
    "Ceará": ["Fortaleza", "Caucaia", "Juazeiro do Norte", "Sobral"],
    "Distrito Federal": ["Brasília", "Ceilândia", "Taguatinga", "Samambaia"],
    "Espírito Santo": ["Vitória", "Vila Velha", "Serra", "Cariacica"],
    "Goiás": ["Goiânia", "Aparecida de Goiânia", "Anápolis", "Rio Verde"],
    "Maranhão": ["São Luís", "Imperatriz", "Caxias", "Timon"],
    // Adicione os demais estados e suas cidades aqui
};

document.getElementById('estado').addEventListener('change', function() {
    const estadoSelecionado = this.value; // Pega o valor do estado selecionado
    const cidadeSelect = document.getElementById('cidade'); // Seleciona o campo de cidades
    cidadeSelect.innerHTML = '<option value="">Selecione</option>'; // Reseta as opções de cidade

    if (estadoSelecionado) {
        const cidades = cidadesPorEstado[estadoSelecionado]; // Pega as cidades para o estado selecionado

        cidades.forEach(cidade => {
            const option = document.createElement('option');
            option.value = cidade.toLowerCase();
            option.textContent = cidade;
            cidadeSelect.appendChild(option); // Adiciona a cidade à lista
        });
    }
});
