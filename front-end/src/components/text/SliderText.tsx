import { useEffect, useState } from 'react';
import styles from './SliderText.module.css';

type TypeSliderText = {
  texts: string[]
  timer?: number
  animation?: 'top' | 'bottom' | 'left' | 'right'
}

export default function SliderText({texts, timer = 3, animation = 'left'}: TypeSliderText){
  
  const [indexText, setIndexText] = useState(0);
  const [positionAnimation, setPositionAnimation] = useState<string>();

  useEffect(() => {
    const interval = setInterval(() => {
      if(!positionAnimation){
        setPositionAnimation(animation);
        setTimeout(() => {
          setIndexText(!texts[indexText+1] ? 0 : indexText+1);
          setPositionAnimation(undefined);
        }, 350);
      }
    }, timer * 1000 + 350);
    return () => {
      clearInterval(interval);
    };
  }, [indexText, timer, animation, positionAnimation, texts]);

  return(
    <h5 className={`${styles.sliderPosition0} ${positionAnimation && styles[positionAnimation]}`}>
      {texts[indexText]}
    </h5>
  );
}