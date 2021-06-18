package org.devon.middleware.hbase;


import java.util.List;


/**
 * @author dewen.ye
 * @datetime 2019/10/29 2:50 PM
 * @since
 */
public class ScanQueryParam implements Param{

    private String table;

    private List<KeyRangeTuple> keyRangeTuples;
    private String[] familys;
    private List<String> qualifierList;

    public ScanQueryParam(String table, List<KeyRangeTuple> keyRangeTuples, String[] familys, List<String> qualifierList) {
        this.table = table;
        this.keyRangeTuples = keyRangeTuples;
        this.familys = familys;
        this.qualifierList = qualifierList;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<KeyRangeTuple> getKeyRangeTuples() {
        return keyRangeTuples;
    }

    public void setKeyRangeTuples(List<KeyRangeTuple> keyRangeTuples) {
        this.keyRangeTuples = keyRangeTuples;
    }

    public String[] getFamilys() {
        return familys;
    }

    public void setFamilys(String[] familys) {
        this.familys = familys;
    }

    public List<String> getQualifierList() {
        return qualifierList;
    }

    public void setQualifierList(List<String> qualifierList) {
        this.qualifierList = qualifierList;
    }

    public byte[][] toQualifiers() {
        if(qualifierList!=null && !qualifierList.isEmpty()){
            byte[][] qualifiers= new byte[qualifierList.size()][];
            for (int i = 0; i < qualifierList.size(); i++) {
                qualifiers[i] = qualifierList.get(i).getBytes();
            }
            return qualifiers;
        }
        return null;
    }

    public void setQualifiers(List<String> qualifierList) {
        this.qualifierList = qualifierList;
    }
}
