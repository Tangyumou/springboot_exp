package cn.tqw.twodatabase.pojo;

import java.util.Date;

public class FilePath {
    private Integer index;
    private String ID;
    private String name;
    private String path;
    private String city;
    private String hospital;
    private String keShi;
    private Date time;
    private String pcPath;
    private String PDFPath;
    private String ganQie;
    private String videoPath;
    private String sparePath;
    private String fenDuanPath;
    private String dataLeiXing;
    private String QRCode;
    private String DicomPath;
    private String CTPath;
    private String STLPath;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getKeShi() {
        return keShi;
    }

    public void setKeShi(String keShi) {
        this.keShi = keShi;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPcPath() {
        return pcPath;
    }

    public void setPcPath(String pcPath) {
        this.pcPath = pcPath;
    }

    public String getPDFPath() {
        return PDFPath;
    }

    public void setPDFPath(String PDFPath) {
        this.PDFPath = PDFPath;
    }

    public String getGanQie() {
        return ganQie;
    }

    public void setGanQie(String ganQie) {
        this.ganQie = ganQie;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getSparePath() {
        return sparePath;
    }

    public void setSparePath(String sparePath) {
        this.sparePath = sparePath;
    }

    public String getFenDuanPath() {
        return fenDuanPath;
    }

    public void setFenDuanPath(String fenDuanPath) {
        this.fenDuanPath = fenDuanPath;
    }

    public String getDataLeiXing() {
        return dataLeiXing;
    }

    public void setDataLeiXing(String dataLeiXing) {
        this.dataLeiXing = dataLeiXing;
    }

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }

    public String getDicomPath() {
        return DicomPath;
    }

    public void setDicomPath(String dicomPath) {
        DicomPath = dicomPath;
    }

    public String getCTPath() {
        return CTPath;
    }

    public void setCTPath(String CTPath) {
        this.CTPath = CTPath;
    }

    public String getSTLPath() {
        return STLPath;
    }

    public void setSTLPath(String STLPath) {
        this.STLPath = STLPath;
    }

    @Override
    public String toString() {
        return "FilePath{" +
                "index=" + index +
                ", ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", city='" + city + '\'' +
                ", hospital='" + hospital + '\'' +
                ", keShi='" + keShi + '\'' +
                ", time=" + time +
                ", pcPath='" + pcPath + '\'' +
                ", PDFPath='" + PDFPath + '\'' +
                ", ganQie='" + ganQie + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", sparePath='" + sparePath + '\'' +
                ", fenDuanPath='" + fenDuanPath + '\'' +
                ", dataLeiXing='" + dataLeiXing + '\'' +
                ", QRCode='" + QRCode + '\'' +
                ", DicomPath='" + DicomPath + '\'' +
                ", CTPath='" + CTPath + '\'' +
                ", STLPath='" + STLPath + '\'' +
                '}';
    }
}
