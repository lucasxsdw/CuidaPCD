const cidadesPorEstado = {
      "Acre": [
          "Acrelândia", "Assis Brasil", "Brasiléia", "Bujari", "Capixaba", 
          "Cruzeiro do Sul", "Epitaciolândia", "Feijó", "Jordão", "Mâncio Lima", 
          "Manoel Urbano", "Marechal Thaumaturgo", "Plácido de Castro", "Porto Acre", 
          "Porto Walter", "Rio Branco", "Rodrigues Alves", "Santa Rosa do Purus", 
          "Sena Madureira", "Senador Guiomard", "Tarauacá", "Xapuri"
        ],
        "Alagoas": [
          "Água Branca", "Anadia", "Arapiraca", "Atalaia", "Barra de Santo Antônio", 
          "Barra de São Miguel", "Batalha", "Belém", "Belo Monte", "Boca da Mata", 
          "Branquinha", "Cacimbinhas", "Cajueiro", "Campestre", "Campo Alegre", 
          "Campo Grande", "Canapi", "Capela", "Carneiros", "Chã Preta", 
          "Coité do Nóia", "Colônia Leopoldina", "Coqueiro Seco", "Coruripe", 
          "Craíbas", "Delmiro Gouveia", "Dois Riachos", "Estrela de Alagoas", 
          "Feira Grande", "Feliz Deserto", "Flexeiras", "Girau do Ponciano", 
          "Ibateguara", "Igaci", "Igreja Nova", "Inhapi", "Jacaré dos Homens", 
          "Jacuípe", "Japaratinga", "Jaramataia", "Jequiá da Praia", "Joaquim Gomes", 
          "Jundiá", "Junqueiro", "Lagoa da Canoa", "Limoeiro de Anadia", "Maceió", 
          "Major Isidoro", "Mar Vermelho", "Maragogi", "Maravilha", "Marechal Deodoro", 
          "Maribondo", "Mata Grande", "Matriz de Camaragibe", "Messias", "Minador do Negrão", 
          "Monteirópolis", "Murici", "Novo Lino", "Olho d'Água das Flores", 
          "Olho d'Água do Casado", "Olho d'Água Grande", "Olivença", "Ouro Branco", 
          "Palestina", "Palmeira dos Índios", "Pão de Açúcar", "Pariconha", "Paripueira", 
          "Passo de Camaragibe", "Paulo Jacinto", "Penedo", "Piaçabuçu", "Pilar", 
          "Pindoba", "Piranhas", "Poço das Trincheiras", "Porto Calvo", "Porto de Pedras", 
          "Porto Real do Colégio", "Quebrangulo", "Rio Largo", "Roteiro", "Santa Luzia do Norte", 
          "Santana do Ipanema", "Santana do Mundaú", "São Brás", "São José da Laje", 
          "São José da Tapera", "São Luís do Quitunde", "São Miguel dos Campos", 
          "São Miguel dos Milagres", "São Sebastião", "Satuba", "Senador Rui Palmeira", 
          "Tanque d'Arca", "Taquarana", "Teotônio Vilela", "Traipu", "União dos Palmares", 
          "Viçosa"
        ],
        "Amapá": [
          "Amapá", "Calçoene", "Cutias", "Ferreira Gomes", "Itaubal", "Laranjal do Jari", 
          "Macapá", "Mazagão", "Oiapoque", "Pedra Branca do Amapari", "Porto Grande", 
          "Pracuúba", "Santana", "Serra do Navio", "Tartarugalzinho", "Vitória do Jari"
        ],
        "Amazonas": [
          "Alvarães", "Amaturá", "Anamã", "Anori", "Apuí", "Atalaia do Norte", 
          "Autazes", "Barcelos", "Barreirinha", "Benjamin Constant", "Beruri", 
          "Boa Vista do Ramos", "Boca do Acre", "Borba", "Caapiranga", "Canutama", 
          "Carauari", "Careiro", "Careiro da Várzea", "Coari", "Codajás", 
          "Eirunepé", "Envira", "Fonte Boa", "Guajará", "Humaitá", "Ipixuna", 
          "Iranduba", "Itacoatiara", "Itamarati", "Itapiranga", "Japurá", 
          "Juruá", "Jutaí", "Lábrea", "Manacapuru", "Manaquiri", "Manaus", 
          "Manicoré", "Maraã", "Maués", "Nhamundá", "Nova Olinda do Norte", 
          "Novo Airão", "Novo Aripuanã", "Parintins", "Pauini", "Presidente Figueiredo", 
          "Rio Preto da Eva", "Santa Isabel do Rio Negro", "Santo Antônio do Içá", 
          "São Gabriel da Cachoeira", "São Paulo de Olivença", "São Sebastião do Uatumã", 
          "Silves", "Tabatinga", "Tapauá", "Tefé", "Tonantins", "Uarini", 
          "Urucará", "Urucurituba"
        ],
       
        "Bahia": [
    "Abaíra", "Abaré", "Acajutiba", "Adustina", "Água Fria", "Aiquara", 
    "Alagoinhas", "Alcobaça", "Almadina", "Amargosa", "Amélia Rodrigues", 
    "América Dourada", "Anagé", "Andaraí", "Andorinha", "Angical", 
    "Anguera", "Antas", "Antônio Cardoso", "Antônio Gonçalves", "Aporá", 
    "Apuarema", "Araças", "Aracatu", "Araci", "Aramari", "Arataca", 
    "Aratuípe", "Aurelino Leal", "Baianópolis", "Baixa Grande", "Banzaê", 
    "Barra", "Barra da Estiva", "Barra do Choça", "Barra do Mendes", 
    "Barra do Rocha", "Barreiras", "Barro Alto", "Barrocas", "Barro Preto", 
    "Belmonte", "Belo Campo", "Biritinga", "Boa Nova", "Boa Vista do Tupim", 
    "Bom Jesus da Lapa", "Bom Jesus da Serra", "Boninal", "Bonito", 
    "Boquira", "Botuporã", "Brejões", "Brejolândia", "Brotas de Macaúbas", 
    "Brumado", "Buerarema", "Buritirama", "Caatiba", "Cabaceiras do Paraguaçu", 
    "Cachoeira", "Caculé", "Caém", "Caetanos", "Caetité", "Cafarnaum", 
    "Cairu", "Caldeirão Grande", "Camacan", "Camaçari", "Camamu", 
    "Campo Alegre de Lourdes", "Campo Formoso", "Canápolis", "Canarana", 
    "Canavieiras", "Candeal", "Candeias", "Candiba", "Cândido Sales", 
    "Cansanção", "Canudos", "Capela do Alto Alegre", "Capim Grosso", 
    "Caraíbas", "Caravelas", "Cardeal da Silva", "Carinhanha", 
    "Casa Nova", "Castro Alves", "Catolândia", "Catu", "Caturama", 
    "Central", "Chorrochó", "Cícero Dantas", "Cipó", "Coaraci", 
    "Cocos", "Conceição da Feira", "Conceição do Almeida", "Conceição do Coité", 
    "Conceição do Jacuípe", "Conde", "Condeúba", "Contendas do Sincorá", 
    "Coração de Maria", "Cordeiros", "Coribe", "Coronel João Sá", 
    "Correntina", "Cotegipe", "Cravolândia", "Crisópolis", "Cristópolis", 
    "Cruz das Almas", "Curaçá", "Dário Meira", "Dias d'Ávila", "Dom Basílio", 
    "Dom Macedo Costa", "Elísio Medrado", "Encruzilhada", "Entre Rios", 
    "Érico Cardoso", "Esplanada", "Euclides da Cunha", "Eunápolis", 
    "Fátima", "Feira da Mata", "Feira de Santana", "Filadélfia", "Firmino Alves", 
    "Floresta Azul", "Formosa do Rio Preto", "Gandu", "Gavião", "Gentio do Ouro", 
    "Glória", "Gongogi", "Governador Mangabeira", "Guajeru", "Guanambi", 
    "Guaratinga", "Heliópolis", "Iaçu", "Ibiassucê", "Ibicaraí", "Ibicoara", 
    "Ibicuí", "Ibipeba", "Ibipitanga", "Ibiquera", "Ibirapitanga", 
    "Ibirapuã", "Ibirataia", "Ibitiara", "Ibititá", "Ibotirama", "Ichu", 
    "Igaporã", "Igrapiúna", "Iguaí", "Ilhéus", "Inhambupe", "Ipecaetá", 
    "Ipiaú", "Ipirá", "Ipupiara", "Irajuba", "Iramaia", "Iraquara", 
    "Irará", "Irecê", "Itabela", "Itaberaba", "Itabuna", "Itacaré", 
    "Itaeté", "Itagi", "Itagibá", "Itagimirim", "Itaguaçu da Bahia", 
    "Itaju do Colônia", "Itajuípe", "Itamaraju", "Itamari", "Itambé", 
    "Itanagra", "Itanhém", "Itaparica", "Itapé", "Itapebi", "Itapetinga", 
    "Itapicuru", "Itapitanga", "Itaquara", "Itarantim", "Itatim", 
    "Itiruçu", "Itiúba", "Itororó", "Ituaçu", "Ituberá", "Iuiú", 
    "Jaborandi", "Jacaraci", "Jacobina", "Jaguaquara", "Jaguarari", 
    "Jaguaripe", "Jandaíra", "Jequié", "Jeremoabo", "Jiquiriçá", 
    "Jitaúna", "João Dourado", "Juazeiro", "Jucuruçu", "Jussara", 
    "Jussari", "Jussiape", "Lafaiete Coutinho", "Lagoa Real", "Laje", 
    "Lajedão", "Lajedinho", "Lajedo do Tabocal", "Lamarão", "Lapão", 
    "Lauro de Freitas", "Lençóis", "Licínio de Almeida", "Livramento de Nossa Senhora"
  ],

  "Ceará": [
    "Fortaleza", "Caucaia", "Juazeiro do Norte", "Sobral", "Maracanaú", "Crato", "Iguatu", "Aquiraz", "Messejana", "Itapipoca", "Tianguá", 
    "Quixadá", "Russas", "Aracati", "Limoeiro do Norte", "Barbalha", "Canindé", "Boa Viagem", "São Gonçalo do Amarante", "Baturité", 
    "Pacatuba", "Horizonte", "Acarape", "Acaraú", "Alto Santo", "Antonina do Norte", "Aracoiaba", "Ararendá", "Assaré", "Aurora", "Baixio", 
    "Barreira", "Beberibe", "Bela Cruz", "Boa Viagem", "Brejo Santo", "Camocim", "Capistrano", "Caridade", "Cascavel", "Chaval", "Cipó", 
    "Icó", "Ipu", "Iracema", "Itapajé", "Itatira", "Jaguaribe", "Jaguaruana", "Juazeiro do Norte", "Maranguape", "Massapê", "Mombaça", 
    "Mucambo", "Mundaú", "Nova Russas", "Pacajus", "Palmácia", "Paracuru", "Pereiro", "Pindoretama", "Piquet Carneiro", "Poranga", "Porteiras", 
    "Quixeramobim", "Quixeré", "Redenção", "Russas", "São Benedito", "São João do Jaguaribe", "São José de Ribamar", "Senador Pompeu", "Senador Sá",
    "Sobral", "Solonópole", "Tamboril", "Tianguá", "Trairi", "Varjota", "Várzea Alegre", "Viçosa do Ceará"
  ],
  
  "Distrito Federal": [
    "Brasília", "Ceilândia", "Taguatinga", "Samambaia", "Águas Claras", "Guará", "Planaltina", "Sobradinho", "Recanto das Emas", 
    "Lago Sul", "Lago Norte", "Sudoeste/Octogonal", "Cruzeiro", "Gama", "Candangolândia", "Riacho Fundo I", "Riacho Fundo II", 
    "São Sebastião", "Paranoá", "Itapoã", "Jardim Botânico", "Varjão", "Córrego do Arrozal", "Córrego do Mandu", "Fazendinha"
  ],

  "Espírito Santo": [
    "Vitória", "Vila Velha", "Serra", "Cariacica", "Cachoeiro de Itapemirim", "Linhares", "Colatina", "Guarapari", "São Mateus", 
    "Montanha", "Conceição da Barra", "Viana", "Anchieta", "Domingos Martins", "Santa Teresa", "Fundão", "Aracruz", "Itapemirim", "Marechal Floriano",
    "Muqui", "Pedro Canário", "Santa Leopoldina", "Vargem Alta", "Pancas", "São Gabriel da Palha", "Ibatiba", "Alfredo Chaves", "Atilio Vivacqua", 
    "Apiacá", "Castelo", "São José do Calçado", "Vila Pavão", "Pinheiros", "Nova Venécia", "Linhares", "Alegre"
  ],

  "Goiás": [
    "Goiânia", "Aparecida de Goiânia", "Anápolis", "Rio Verde", "Luziânia", "Catalão", "Formosa", "Itumbiara", "Jataí", "Trindade", 
    "Águas Lindas de Goiás", "Ceres", "Morrinhos", "Novo Gama", "Planaltina", "Rianápolis", "Valparaíso de Goiás", "Alexânia", "Alvorada do Norte",
    "Bela Vista de Goiás", "Bom Jesus de Goiás", "Buriti Alegre", "Caiapônia", "Caldas Novas", "Carmo do Rio Verde", "Cascalho Rico", "Chapada dos Veadeiros",
    "Cocalzinho de Goiás", "Cristalina", "Goianésia", "Goiatuba", "Iaciara", "Inhumas", "Ipameri", "Itaberaí", "Itapirapuã", "Itauçu", "Ivolândia",
    "Jaraguá", "Joviânia", "Luziânia", "Mimoso de Goiás", "Montividiu", "Morrinhos", "Nova Crixás", "Nova Glória", "Novo Planalto", "Padre Bernardo", 
    "Palmeiras de Goiás", "Piracanjuba", "Pirenópolis", "Planaltina", "Pontalina", "Posse", "Porteirão", "São João d'Aliança", "São Luiz do Norte", 
    "Senador Canedo", "Silvânia", "Simolândia", "Vianópolis", "Vicentinópolis", "Águas Lindas de Goiás"
  ],

  "Maranhão": [
    "São Luís", "Imperatriz", "Caxias", "Timon", "Bacabal", "Açailândia", "Codó", "Santa Inês", "Pinheiro", "Balsas", "Chapadinha", "Viana", 
    "Carutapera", "São José de Ribamar", "Barreirinhas", "Pedreiras", "São Mateus do Maranhão", "Rosário", "Tufilândia", "Buriticupu", 
    "Vargem Grande", "Viana", "Altamira do Maranhão", "Afonso Cunha", "Arame", "Barra do Corda", "Benedito Leite", "Boa Vista do Gurupi", 
    "Brejo", "Buriticupu", "Cajapió", "Cândido Mendes", "Catarina do Maranhão", "Caxias", "Coroatá", "Itapecuru-Mirim", "Itinga do Maranhão", 
    "Maranhãozinho", "Matinha", "Mearim", "Mirador", "Mirinzal", "Monção", "Nina", "Pedreiras", "Pinheiro", "Pindaré", "São João do Carú"
  ],

  "Mato Grosso": [
    "Cuiabá", "Várzea Grande", "Rondonópolis", "Sinop", "Lucas do Rio Verde", "Sorriso", "Cáceres", "Tangará da Serra", "Nova Mutum", 
    "Pontes e Lacerda", "Alta Floresta", "Campo Novo do Parecis", "Barra do Garças", "Colíder", "Nortelândia", "Jaciara", "Barra do Bugres", 
    "São Félix do Araguaia", "Matupá", "Chapada dos Guimarães", "Santo Antônio de Leverger", "Peixoto de Azevedo", "Aripuanã", "Nova Xavantina", 
    "Rosário Oeste", "Cuiabá", "Cocalinho", "Porto Alegre do Norte"
  ],

  "Mato Grosso do Sul": [
    "Campo Grande", "Dourados", "Três Lagoas", "Corumbá", "Ponta Porã", "Aquidauana", "Nova Andradina", "Paranaíba", "Coxim", "São Gabriel do Oeste", 
    "Ivinhema", "Sidrolândia", "Cassilândia", "Ribas do Rio Pardo", "Fátima do Sul", "Chapadão do Sul", "Naviraí", "Eldorado", "Glória de Dourados",
    "Amambai", "Caarapó", "Vicentina", "Japorã", "Anastácio", "Aparecida do Taboado", "Itaquiraí", "Itaporã", "Jateí", "Rio Brilhante", "Sete Quedas"
  ],

  "Minas Gerais": [
    "Belo Horizonte", "Uberlândia", "Contagem", "Juiz de Fora", "Betim", "Montes Claros", "Ribeirão das Neves", "Divinópolis", "Governador Valadares", 
    "Ipatinga", "Sete Lagoas", "Uberaba", "Poços de Caldas", "Varginha", "Teófilo Otoni", "Unaí", "Muriaé", "Barbacena", "Passos", "Pouso Alegre", 
    "Diamantina", "Cataguases", "Araguari", "Lavras", "Itabira", "Nova Lima", "Manhuaçu", "Conselheiro Lafaiete", "Pará de Minas", "Caratinga", 
    "Santa Luzia", "Nova Serrana", "Santos Dumont", "João Monlevade", "Montes Claros", "São João Nepomuceno", "Janaúba", "Carmo do Paranaíba", 
    "Viçosa", "Governador Valadares", "Ituiutaba", "São João del-Rei", "Poços de Caldas", "Itaguara", "Ibirité", "Serra Azul", "Curvelo"
  ],

  "Pará": [
    "Belém", "Ananindeua", "Santarém", "Marabá", "Parauapebas", "Castanhal", "Itaituba", "Redenção", "Barcarena", "Bragança", "Altamira", 
    "Mãe do Rio", "Capanema", "São Domingos do Araguaia", "Conceição do Araguaia", "Xinguara", "Tucuruí", "Breves", "Monte Alegre", 
    "Ourém", "Abaetetuba", "Tailandia", "Vigia", "Cametá", "Portel", "Igarapé-Miri", "Capanema", "Benevides", "Soure", "Salinópolis", 
    "São Caetano de Odivelas", "Marituba", "Santo Antônio do Tauá", "Nova Ipixuna", "Rondon do Pará"
  ],

  "Paraíba": [
    "João Pessoa", "Campina Grande", "Santa Rita", "Patos", "Bayeux", "Cabedelo", "Sousa", "Cajazeiras", "Catolé do Rocha", "Montadas", 
    "Alagoa Grande", "São José de Piranhas", "Mamanguape", "Sumé", "Piancó", "Cuité", "Boqueirão", "Ingá", "Aroeiras", "Conde", 
    "Nova Palmeira", "Solânea", "Pombal", "Araruna", "Gurinhém", "Monteiro", "São João do Rio do Peixe", "Itabaiana", "Sapé"
  ],

  "Paraná": [
    "Curitiba", "Londrina", "Maringá", "Ponta Grossa", "Foz do Iguaçu", "Cascavel", "São José dos Pinhais", "Araucária", "Colombo", 
    "Paranaguá", "Guarapuava", "Toledo", "Apucarana", "Campo Mourão", "Cambé", "Umuarama", "Paranavaí", "Irati", "Palmeira", 
    "Lapa", "Castro", "Goioerê", "Laranjeiras do Sul", "Ponta Grossa", "Prudentópolis", "Guaratuba", "Morretes", "Almirante Tamandaré"
  ],

  "Pernambuco": [
    "Recife", "Jaboatão dos Guararapes", "Olinda", "Caruaru", "Petrolina", "Cabo de Santo Agostinho", "Igarassu", "Garanhuns", "Vitória de Santo Antão", 
    "São Lourenço da Mata", "Paulista", "Escada", "Abreu e Lima", "Surubim", "São João de Meriti", "Araripina", "Belo Jardim", 
    "Ouricuri", "Arcoverde", "Santa Cruz do Capibaribe", "Ipojuca", "Limoeiro", "Bom Conselho", "Bezerros", "Triunfo", "Gravatá", 
    "Carpina", "Pesqueira", "Barreiros", "São Vicente Ferrer", "Tabira", "Cabo", "Coroatá"
  ],

  "Piauí": [
    "Teresina", "Parnaíba", "Picos", "Floriano", "Barras", "Pedro II", "Campo Maior", "Esperantina", "São João do Piauí", "Batalha", 
    "Oeiras", "Cocal", "Madeiro", "Buriti dos Lopes", "Altos", "José de Freitas", "Canto do Buriti", "Avelino Lopes", "Cabeceiras do Piauí", 
    "São Raimundo Nonato", "Cocal dos Alves", "São Miguel do Tapuio", "Pavussu", "Aroeiras do Itaim", "Sussuapara", "Inhuma", "Prata do Piauí"
  ],

  "Rio de Janeiro": [
    "Rio de Janeiro", "Niterói", "Nova Iguaçu", "São Gonçalo", "Duque de Caxias", "Belford Roxo", "Campos dos Goytacazes", "Volta Redonda", 
    "Petrópolis", "Cabo Frio", "Macaé", "Angra dos Reis", "Teresópolis", "Itaboraí", "São João de Meriti", "Queimados", "Mesquita", "Japeri", 
    "Paracambi", "Itaguaí", "Nilópolis", "Barra Mansa", "Rio das Ostras", "Araruama", "Resende", "Magé", "Itaocara", "São Fidélis"
  ],

  "Rio Grande do Norte": [
    "Natal", "Mossoró", "Parnamirim", "São Gonçalo do Amarante", "Macau", "Açu", "Caicó", "Currais Novos", "Pau dos Ferros", "Canguaretama", 
    "São José de Mipibu", "Santa Cruz", "João Câmara", "Nova Cruz", "Tangará", "Ceará-Mirim", "São Miguel", "Angicos", "Portalegre", "Parelhas", 
    "Santo Antônio", "Janduís", "Lagoa Nova", "Bodó", "Serrinha", "São Pedro", "São Paulo do Potengi", "Apodi", "Touros", "Macau"
  ],

  "Rio Grande do Sul": [
    "Porto Alegre", "Caxias do Sul", "Pelotas", "Santa Maria", "Gravataí", "Canoas", "Novo Hamburgo", "São Leopoldo", "Passo Fundo", "Bagé", 
    "Rio Grande", "Santa Cruz do Sul", "Lajeado", "Farroupilha", "Ijuí", "Uruguaiana", "São Borja", "Santo Ângelo", "Erechim", "Sapiranga", 
    "São Gabriel", "Lajeado", "Venâncio Aires", "Panambi", "Santana do Livramento", "Xangri-lá", "Viamão", "Cachoeirinha", "São João do Sul"
  ],

  "Rondônia": [
    "Porto Velho", "Ji-Paraná", "Ariquemes", "Cacoal", "Vilhena", "Rolim de Moura", "Buritis", "Guajará-Mirim", "Ouro Preto do Oeste", 
    "Alta Floresta d'Oeste", "São Francisco do Guaporé", "Pimenta Bueno", "Ji-Paraná", "Espigão do Oeste", "Mirante da Serra", "Nova Mamoré", 
    "Campo Novo de Rondônia", "Cujubim", "Vale do Anari", "Cabixi"
  ],
  
  "Roraima": [
    "Boa Vista", "Rorainópolis", "Caracaraí", "Alto Alegre", "Cantá", "Mucajaí", "Normandia", "São João da Baliza", "Iracema", "Uraricoera", 
    "Bonfim", "Caroebe", "Amajari", "São Luiz", "Mucajai"
  ],

  "Santa Catarina": [
    "Florianópolis", "Joinville", "Blumenau", "Criciúma", "Chapecó", "Itajaí", "São José", "Lages", "Jaraguá do Sul", "Balneário Camboriú", 
    "Tubarão", "Pomerode", "Rio do Sul", "Araranguá", "Camboriú", "Brusque", "Palhoça", "Indaial", "Concórdia", "Xanxerê", "Caçador", 
    "São Bento do Sul", "Sao Joaquim", "Univali", "Caçador"
  ],

  "São Paulo": [
    "São Paulo", "Campinas", "Santos", "São Bernardo do Campo", "São José dos Campos", "Sorocaba", "Ribeirão Preto", "São Vicente", 
    "Diadema", "Mauá", "Osasco", "Barueri", "Bauru", "Piracicaba", "Jundiaí", "Carapicuíba", "Limeira", "Franca", "Taubaté", "Botucatu", 
    "Marília", "Mogi das Cruzes", "Presidente Prudente", "Araraquara", "São Carlos", "Taquaritinga", "Itapeva", "Lins", "Bebedouro"
  ],

  "Sergipe": [
    "Aracaju", "Nossa Senhora do Socorro", "Lagarto", "Itabaiana", "Estância", "Propriá", "Barra dos Coqueiros", "Socorro", "Tobias Barreto", 
    "Simão Dias", "São Cristóvão", "Itabaianinha", "Neópolis", "Itaporanga d'Ajuda", "São Miguel do Aleixo", "Arauá", "Boquim", "Divina Pastora"
  ],

  "Tocantins": [
    "Palmas", "Araguaína", "Gurupi", "Paraíso do Tocantins", "Porto Nacional", "Miracema do Tocantins", "Augustinópolis", "Tocantinópolis", 
    "Colinas do Tocantins", "Guaraí", "Alvorada", "Taguatinga", "Pium", "Lajeado", "Monte do Carmo", "Lagoa do Tocantins", "Caseara", "Formoso"
  ]
      
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
