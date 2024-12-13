import Header from '@mod/layout/Header';
import styles from './page.module.css';
import Footer from '@mod/layout/Footer';
import Section from '@cont/Section';
import Article from '@cont/Article';
import LinkText from '@comp/actions/LinkText';

export default function policy(){
  return(
    <>
      <Header theme='dark'/>
      <main className={styles.mainContainer}>
        <Section>
          <h1 className={styles.textCenter}>Política Privacidade</h1>
          <Article>
            <p>
              A sua privacidade é importante para nós. É política do MatHub respeitar a sua privacidade em relação a qualquer informação sua que possamos coletar no site <LinkText hreflang='pt-br' href='/'>MatHub</LinkText>, e outros sites que possuímos e operamos.
            </p>
            <p>
              Solicitamos informações pessoais apenas quando realmente precisamos delas para lhe fornecer um serviço. Fazemo-lo por meios justos e legais, com o seu conhecimento e consentimento. Também informamos por que estamos coletando e como será usado.
            </p>
            <p>
              Apenas retemos as informações coletadas pelo tempo necessário para fornecer o serviço solicitado. Quando armazenamos dados, protegemos dentro de meios comercialmente aceitáveis ​​para evitar perdas e roubos, bem como acesso, divulgação, cópia, uso ou modificação não autorizados.
            </p>
            <p>
              Não compartilhamos informações de identificação pessoal publicamente ou com terceiros, exceto quando exigido por lei.
            </p>
            <p>
              O nosso site pode ter links para sites externos que não são operados por nós. Esteja ciente de que não temos controle sobre o conteúdo e práticas desses sites e não podemos aceitar responsabilidade por suas respectivas políticas de privacidade.
            </p>
            <p>
              Você é livre para recusar a nossa solicitação de informações pessoais, entendendo que talvez não possamos fornecer alguns dos serviços desejados.
            </p>
            <p>
              O uso continuado de nosso site será considerado como aceitação de nossas práticas em torno de privacidade e informações pessoais. Se você tiver alguma dúvida sobre como lidamos com dados do usuário e informações pessoais, entre em contacto connosco.
            </p>
            
            <ul id='cookies'>
              <li>
                O serviço Google AdSense que usamos para veicular publicidade usa um <strong>cookie</strong> DoubleClick para veicular anúncios mais relevantes em toda a Web e limitar o número de vezes que um determinado anúncio é exibido para você.
              </li>
              <li>
                Para mais informações sobre o Google AdSense, consulte as FAQs oficiais sobre privacidade do Google AdSense.
              </li>
              <li>
                Utilizamos anúncios para compensar os custos de funcionamento deste site e fornecer financiamento para futuros desenvolvimentos. Os <strong>cookies</strong> de publicidade comportamental usados ​​por este site foram projetados para garantir que você forneça os anúncios mais relevantes sempre que possível, rastreando anonimamente seus interesses e apresentando coisas semelhantes que possam ser do seu interesse.
              </li>
              <li>
                Vários parceiros anunciam em nosso nome e os <strong>cookies</strong> de rastreamento de afiliados simplesmente nos permitem ver se nossos clientes acessaram o site através de um dos sites de nossos parceiros, para que possamos creditá-los adequadamente e, quando aplicável, permitir que nossos parceiros afiliados ofereçam qualquer promoção que pode fornecê-lo para fazer uma compra.
              </li>
            </ul>

            <h4>Compromisso do Usuário</h4>
            <p>
              O usuário se compromete a fazer uso adequado dos conteúdos e da informação que o MatHub oferece no site e com caráter enunciativo, mas não limitativo:
            </p>
            <ul>
              <li>
                A) Não se envolver em atividades que sejam ilegais ou contrárias à boa fé a à ordem pública;
              </li>
              <li>
                B) Não difundir propaganda ou conteúdo de natureza racista, xenofóbica, 166bet ou azar, qualquer tipo de pornografia ilegal, de apologia ao terrorismo ou contra os direitos humanos;
              </li>
              <li>
                C) Não causar danos aos sistemas físicos (hardwares) e lógicos (softwares) do MatHub, de seus fornecedores ou terceiros, para introduzir ou disseminar vírus informáticos ou quaisquer outros sistemas de hardware ou software que sejam capazes de causar danos anteriormente mencionados.
              </li>
            </ul>

            <h4>Mais informações</h4>
            <p>
              Esperemos que esteja esclarecido e, como mencionado anteriormente, se houver algo que você não tem certeza se precisa ou não, geralmente é mais seguro deixar os <strong>cookies</strong> ativados, caso interaja com um dos recursos que você usa em nosso site.
            </p>

            <p>Esta política é efetiva a partir de 12 December 2024 23:35</p>
          </Article>
        </Section>
      </main>
      <Footer theme='dark' />
    </>
  );
}