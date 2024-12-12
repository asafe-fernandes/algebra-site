import Header from '@mod/layout/Header';
import styles from './page.module.css';
import Footer from '@mod/layout/Footer';
import Section from '@cont/Section';
import Article from '@cont/Article';
import LinkText from '@comp/actions/LinkText';

export default function terms(){
  return(
    <>
      <Header theme='dark'/>
      <main className={styles.mainContainer}>
        <Section>
          <h1 className={styles.textCenter}>Termos de Uso</h1>
          <Article>
            <h1>1.Termos</h1>
            <p>
              Ao acessar ao site <LinkText hreflang='pt-br' href='/'>MatHub</LinkText>, concorda em cumprir estes termos de serviço, todas as leis e regulamentos aplicáveis ​​e concorda que é responsável pelo cumprimento de todas as leis locais aplicáveis. Se você não concordar com algum desses termos, está proibido de usar ou acessar este site. Os materiais contidos neste site são protegidos pelas leis de direitos autorais e marcas comerciais aplicáveis.
            </p>

            <h1>2.Uso de Licença</h1>
            <p>
              É concedida permissão para baixar temporariamente uma cópia dos materiais (informações ou software) no site MatHub , apenas para visualização transitória pessoal e não comercial. Esta é a concessão de uma licença, não uma transferência de título e, sob esta licença, você não pode: 
            </p>
            <ol>
              <li>modificar ou copiar os materiais; </li>
              <li>usar os materiais para qualquer finalidade comercial ou para exibição pública (comercial ou não comercial); </li>
              <li>tentar descompilar ou fazer engenharia reversa de qualquer software contido no site MatHub; </li>
              <li>remover quaisquer direitos autorais ou outras notações de propriedade dos materiais; ou </li>
              <li>transferir os materiais para outra pessoa ou &apos;espelhe&apos; os materiais em qualquer outro servidor.</li>
            </ol>
            <p>
              Esta licença será automaticamente rescindida se você violar alguma dessas restrições e poderá ser rescindida por MatHub a qualquer momento. Ao encerrar a visualização desses materiais ou após o término desta licença, você deve apagar todos os materiais baixados em sua posse, seja em formato eletrónico ou impresso.
            </p>

            <h2>3.Isenção de responsabilidade</h2>
            <ol>
              <li>
                Os materiais no site da MatHub são fornecidos &apos;como estão&apos;. MatHub não oferece garantias, expressas ou implícitas, e, por este meio, isenta e nega todas as outras garantias, incluindo, sem limitação, garantias implícitas ou condições de comercialização, adequação a um fim específico ou não violação de propriedade intelectual ou outra violação de direitos.
              </li>
              <li>
                Além disso, o MatHub não garante ou faz qualquer representação relativa à precisão, aos resultados prováveis ​​ou à confiabilidade do uso dos materiais em seu site ou de outra forma relacionado a esses materiais ou em sites vinculados a este site.
              </li>
            </ol>

            <h2>4.Limitações</h2>
            <p>
              Em nenhum caso o MatHub ou seus fornecedores serão responsáveis ​​por quaisquer danos (incluindo, sem limitação, danos por perda de dados ou lucro ou devido a interrupção dos negócios) decorrentes do uso ou da incapacidade de usar os materiais em MatHub, mesmo que MatHub ou um representante autorizado da MatHub tenha sido notificado oralmente ou por escrito da possibilidade de tais danos. Como algumas jurisdições não permitem limitações em garantias implícitas, ou limitações de responsabilidade por danos conseqüentes ou incidentais, essas limitações podem não se aplicar a você.
            </p>

            <h2>5.Precisão dos materiais</h2>
            <p>
              Os materiais exibidos no site da MatHub podem incluir erros técnicos, tipográficos ou fotográficos. MatHub não garante que qualquer material em seu site seja preciso, completo ou atual. MatHub pode fazer alterações nos materiais contidos em seu site a qualquer momento, sem aviso prévio. No entanto, MatHub não se compromete a atualizar os materiais.
            </p>

            <h2>6.Links</h2>
            <p>
              O MatHub não analisou todos os sites vinculados ao seu site e não é responsável pelo conteúdo de nenhum site vinculado. A inclusão de qualquer link não implica endosso por MatHub do site. O uso de qualquer site vinculado é por conta e risco do usuário.
            </p>

            <h4>Modificações</h4>
            <p>
              O MatHub pode revisar estes termos de serviço do site a qualquer momento, sem aviso prévio. Ao usar este site, você concorda em ficar vinculado à versão atual desses termos de serviço.
            </p>

            <h4>Lei aplicável</h4>
            <p>
              Estes termos e condições são regidos e interpretados de acordo com as leis do MatHub e você se submete irrevogavelmente à jurisdição exclusiva dos tribunais naquele estado ou localidade.
            </p>
          </Article>
        </Section>
      </main>
      <Footer theme='dark' />
    </>
  );
}