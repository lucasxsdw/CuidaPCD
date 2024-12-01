async function carregarProfissionais() {
    try {
        const response = await fetch('http://localhost:8080/api/profissionais');
        const profissionais = await response.json();

        const container = document.getElementById('profissional');
        profissionais.forEach(profissional => {
            const div = document.createElement('div');
            div.className = 'quadradoPro';
            div.innerHTML = `
                <div class="foto">
                    <img src="http://localhost:8080/${profissional.arquivoFoto}" alt="Foto de Perfil" width="200" id="fotofoto">
                </div>
                <div class="botoesPro">
                    <button class="botao-profissional">${profissional.formacao || 'Formação não informada'}</button>
                    <button class="botao-profissional">12 km</button>
                    <button class="botao-profissional1">Disponível</button>
                </div>
                <div>
                    <h6 id="Nome">${profissional.nome}</h6>
                </div>
                <div class="sobremim">
                    <p id="sobre">${profissional.sobre || 'Sem informações adicionais.'}</p>
                </div>
                <div class="local">
                    <img src="images/Local png.png" id="iconelocal">
                    <p id="localizacao">${profissional.endereco.rua}, ${profissional.endereco.numero}, ${profissional.endereco.cidade} - ${profissional.endereco.estado}</p>
                </div>
                <div class="vermais">
                    <a href= "/perfil/${profissional.id}"> <button class="botao-vermais">Ver Mais</button> </a>
                </div>
            `;
            container.appendChild(div);
        });
    } catch (error) {
        console.error('Erro ao carregar os profissionais:', error);
    }
}

// Carregar os profissionais ao abrir a página
carregarProfissionais();