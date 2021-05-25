package sample;


public class Lista_slowek implements Comparable<Lista_slowek> {
        private String s_polski;
        private String s_niemiecki;
        private  Integer wiem;
        private  Integer nie_wiem;

    public String getS_polski() {
        return s_polski;
    }

    public void setS_polski(String s_polski) {
        this.s_polski = s_polski;
    }

    public String getS_niemiecki() {
        return s_niemiecki;
    }

    public void setS_niemiecki(String s_niemiecki) {
        this.s_niemiecki = s_niemiecki;
    }

    public Integer getWiem() {
        return wiem;
    }

    public void setWiem(Integer wiem) {
        this.wiem = wiem;
    }

    public Integer getNie_wiem() {
        return nie_wiem;
    }

    public void setNie_wiem(Integer nie_wiem) {
        this.nie_wiem = nie_wiem;
    }

    public Lista_slowek(String s_polski, String s_niemiecki, Integer wiem, Integer nie_wiem) {
            this.s_polski = new String(s_polski);
            this.s_niemiecki = new String(s_niemiecki);
            this.wiem = wiem;
            this.nie_wiem = nie_wiem;
        }

    public Lista_slowek(){
        this.s_polski="";
        this.s_niemiecki="";
        this.wiem=0;
        this.nie_wiem=0;
    }

        @Override
        public int compareTo(Lista_slowek o) {
            if (this.getWiem()<o.getWiem()) return -1;
            if (this.getWiem()>o.getWiem()) return 1;
            return 0;
        }
    }

