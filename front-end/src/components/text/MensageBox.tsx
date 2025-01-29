import Button from '@comp/actions/Button';
import styles from './MensageBox.module.css';
import TypeMensageBox from '@tps/typeMensageBox';
import { useEffect, useState } from 'react';

export default function MensageBox(mensageObj: TypeMensageBox){
  const [show, setShow] = useState(false);

  useEffect(() => {
    const timeoutIn = setTimeout(() => {
      setShow(true);
    }, 10);

    return () => {
      clearTimeout(timeoutIn);
    };
  }, []);

  useEffect(() => {
    if(mensageObj.type == 'default' || !mensageObj.type){
      const timeoutOut = setTimeout(() => {
        setShow(false);
      }, 4000);
  
      return () => {
        clearTimeout(timeoutOut);
      };
    }
  }, [mensageObj.type]);

  function confirmation(){
    setShow(false);
    if(mensageObj.response) mensageObj.response();
  }

  return(
    <>{mensageObj &&
      <div className={`${styles.mensageContainer} ${show && styles.mensageShow} ${mensageObj.theme && styles[mensageObj.theme]}`}>
        {mensageObj.content?.split('\n').map((msg, index) => <div key={`MensageBox_${index}`}>{
          index == 0 &&
          mensageObj.content?.split('\n').length && 
          mensageObj.content?.split('\n').length > 1 ? 
            <h4 key={`MensageBox_content_${index}`}>{msg}</h4>
            :
            <p key={`MensageBox_content_${index}`}>{msg}</p>
        }</div>)} 
        <div className={styles.containerButtonConfirm}>
          {mensageObj.type == 'confirm' && <Button onClick={confirmation}>Confirmar</Button>}
        </div>
      </div>
    }</>
  );
}