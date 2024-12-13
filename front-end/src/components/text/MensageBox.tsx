import styles from './MensageBox.module.css';
import TypeMensageBox from '@tps/typeMensageBox';
import { useEffect, useState } from 'react';

export default function MensageBox({mensageObj}: {mensageObj: TypeMensageBox}){
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
    const timeoutOut = setTimeout(() => {
      setShow(false);
    }, 4000);

    return () => {
      clearTimeout(timeoutOut);
    };
  }, []);

  return(
    <>{mensageObj &&
      <div className={`${styles.mensageContainer} ${show && styles.mensageShow} ${mensageObj.theme && styles[mensageObj.theme]}`}>
        <p>{mensageObj.content}</p> 
      </div>
    }</>
  );
}