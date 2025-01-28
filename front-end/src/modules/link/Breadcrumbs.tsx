'use client';

import { JSX, useEffect, useState } from 'react';
import styles from './Breadcrumbs.module.css';
import LinkText from '@comp/actions/LinkText';
import {usePathname } from 'next/navigation';
import { BsFolderSymlinkFill } from 'react-icons/bs';

export default function Breadcrumbs(){
  const [listLink, setListLink] = useState<JSX.Element[]>();
  const pathname = usePathname();

  useEffect(() => {
    const path = pathname.split('/');

    if(path[1] != ''){
      setListLink(
        path.map((item, index) => {
          return <p key={`Breadcrumbs_${index}`}>
            {index > 0 ? 
              <span key={`Breadcrumbs_${index}_divisor`}>&gt;</span> :
              <BsFolderSymlinkFill className={styles.icon}/>
            }
            <LinkText 
              style={index+1 == path.length ? 'detach' : undefined} 
              href={pathname.split(path[index+1])[0]} key={`Breadcrumbs_${index}_Link`}
            >
              {item == '' ? 'MatHub' : decodeURIComponent(item)}
            </LinkText>
          </p>;
        })
      );
    }
  }, [pathname]);

  return(
    <nav className={styles.navContainer}>
      {listLink}
    </nav>
  );
}