import styles from './PatternSVG.module.css';

export default function PatternSVG({...props}){
  return(
    <div {...props}>
      <svg className={styles.patternContainer} xmlns='http://www.w3.org/2000/svg' viewBox='0 0 800 800'>
        <rect fill='#33003300' width='800' height='800'/>
        <g fill='none' stroke='#0000000f'  stroke-width='1'>
          <path d='M769 229L1037 260.9M927 880L731 737 520 660 309 538 40 599 295 764 126.5 879.5 40 599-197 493 102 382-31 229 126.5 79.5-69-63'/>
          <path d='M-31 229L237 261 390 382 603 493 308.5 537.5 101.5 381.5M370 905L295 764'/>
          <path d='M520 660L578 842 731 737 840 599 603 493 520 660 295 764 309 538 390 382 539 269 769 229 577.5 41.5 370 105 295 -36 126.5 79.5 237 261 102 382 40 599 -69 737 127 880'/>
          <path d='M520-140L578.5 42.5 731-63M603 493L539 269 237 261 370 105M902 382L539 269M390 382L102 382'/>
          <path d='M-222 42L126.5 79.5 370 105 539 269 577.5 41.5 927 80 769 229 902 382 603 493 731 737M295-36L577.5 41.5M578 842L295 764M40-201L127 80M102 382L-261 269'/>
        </g>
        <g  fill='#0000005f'><circle  cx='769' cy='229' r='5'/>
          <circle  cx='539' cy='269' r='5'/>
          <circle  cx='603' cy='493' r='5'/>
          <circle  cx='731' cy='737' r='5'/>
          <circle  cx='520' cy='660' r='5'/>
          <circle  cx='309' cy='538' r='5'/>
          <circle  cx='295' cy='764' r='5'/>
          <circle  cx='40' cy='599' r='5'/>
          <circle  cx='102' cy='382' r='5'/>
          <circle  cx='127' cy='80' r='5'/>
          <circle  cx='370' cy='105' r='5'/>
          <circle  cx='578' cy='42' r='5'/>
          <circle  cx='237' cy='261' r='5'/>
          <circle  cx='390' cy='382' r='5'/>
        </g>
      </svg>
    </div>
  );
}