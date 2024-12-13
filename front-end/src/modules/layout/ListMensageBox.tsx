'use client';

import styles from './ListMensageBox.module.css';
import { useSelector } from 'react-redux';
import TypeMensageBox from '@tps/typeMensageBox';
import MensageBox from '@comp/text/MensageBox';
import { useEffect, useState } from 'react';

export default function ListMensageBox(){
  const mensageBox = useSelector((state: {mensageBox: TypeMensageBox}) => state.mensageBox);
  const [mensage, setMensage] = useState<TypeMensageBox>();
  const [listMensage, setListMensage] = useState<TypeMensageBox[]>([]);
  const [showListMensage, setShowListMensage] = useState<TypeMensageBox[]>([]);

  useEffect(() => { if(mensageBox.content) setMensage(mensageBox); }, [mensageBox]);

  useEffect(() => {
    if(mensage){
      setListMensage([...listMensage, mensage]);
      setMensage(undefined);
    }
  }, [mensage, listMensage]);

  useEffect(() => {

    const interval = setInterval(() => {
      if(listMensage[0]?.content){
        const newList = listMensage;
        newList.shift();
        setListMensage([...newList]);
      }
    }, 5000);

    return () => clearInterval(interval);
  }, [listMensage]);

  useEffect(() => setShowListMensage(listMensage), [listMensage]);

  return(
    <ul className={styles.listContainer}>
      {showListMensage.map((msg, index) => <li key={`mensage_list_${index}`}><MensageBox mensageObj={msg} /></li>)}
    </ul>
  );
}