document.addEventListener('DOMContentLoaded', () => {
    const avancarBtn = document.getElementById('avancar-btn');
    const escolhaContainer = document.querySelector('.escolha-tipo');
    const usuarioBtn = document.getElementById('usuario-btn');
    const medicoBtn = document.getElementById('medico-btn');
    const medicoFields = document.querySelector('.medico-fields');
    const mensagemSucesso = document.querySelector('.mensagem-sucesso');
    const cadastroForm = document.getElementById('cadastro-form');
    const adicionarExperiencia = document.getElementById('adicionar-experiencia');
    const experienciaContainer = document.getElementById('experiencia-container');
    
    // Avançar para a escolha do tipo de usuário
    avancarBtn.addEventListener('click', () => {
        const nome = document.getElementById('nome').value;
        const sobrenome = document.getElementById('sobrenome').value;
        const email = document.getElementById('email').value;
        const telefone = document.getElementById('telefone').value;
        const senha = document.getElementById('senha').value;
        const confirmarSenha = document.getElementById('confirmarSenha').value;

        if (nome && sobrenome && email && telefone && senha && confirmarSenha) {
            if (senha === confirmarSenha) {
                escolhaContainer.style.display = 'block';
                document.querySelector('.common-fields').style.display = 'none';
            } else {
                alert('As senhas não coincidem.');
            }
        } else {
            alert('Preencha todos os campos.');
        }
    });

    // Escolha médico
    usuarioBtn.addEventListener('click', () => {
        cadastroForm.submit();
    });

    medicoBtn.addEventListener('click', () => {
        medicoFields.style.display = 'block';
        escolhaContainer.style.display = 'none';
    });

    // Adicionar experiência profissional
    adicionarExperiencia.addEventListener('click', () => {
        const div = document.createElement('div');
        div.classList.add('experiencia');
        div.innerHTML = `
            <input type="text" name="local_trabalho" placeholder="Nome do local de trabalho">
            <input type="text" name="tempo_trabalho" placeholder="Tempo de trabalho">
        `;
        experienciaContainer.appendChild(div);
    });

    // Finalizar cadastro do médico
    cadastroForm.addEventListener('submit', (e) => {
        e.preventDefault();
        mensagemSucesso.style.display = 'block';
        cadastroForm.style.display = 'none';
    });
});
