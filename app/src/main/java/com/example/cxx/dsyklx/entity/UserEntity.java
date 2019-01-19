package com.example.cxx.dsyklx.entity;

import java.util.List;

public class UserEntity {
    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private MiaoshaBean miaosha;
        private TuijianBean tuijian;
        private List<BannerBean> banner;
        private List<FenleiBean> fenlei;

        public MiaoshaBean getMiaosha() {
            return miaosha;
        }

        public void setMiaosha(MiaoshaBean miaosha) {
            this.miaosha = miaosha;
        }

        public TuijianBean getTuijian() {
            return tuijian;
        }

        public void setTuijian(TuijianBean tuijian) {
            this.tuijian = tuijian;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<FenleiBean> getFenlei() {
            return fenlei;
        }

        public void setFenlei(List<FenleiBean> fenlei) {
            this.fenlei = fenlei;
        }

        public static class MiaoshaBean {
            private String name;
            private String time;
            private List<ListBean> list;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private double bargainPrice;
                private String createtime;
                private String detailUrl;
                private String images;
                private String itemtype;
                private String pid;
                private String price;
                private String pscid;
                private String salenum;
                private String sellerid;
                private String subhead;
                private String title;

                public double getBargainPrice() {
                    return bargainPrice;
                }

                public void setBargainPrice(double bargainPrice) {
                    this.bargainPrice = bargainPrice;
                }

                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }

                public String getDetailUrl() {
                    return detailUrl;
                }

                public void setDetailUrl(String detailUrl) {
                    this.detailUrl = detailUrl;
                }

                public String getImages() {
                    return images;
                }

                public void setImages(String images) {
                    this.images = images;
                }

                public String getItemtype() {
                    return itemtype;
                }

                public void setItemtype(String itemtype) {
                    this.itemtype = itemtype;
                }

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getPscid() {
                    return pscid;
                }

                public void setPscid(String pscid) {
                    this.pscid = pscid;
                }

                public String getSalenum() {
                    return salenum;
                }

                public void setSalenum(String salenum) {
                    this.salenum = salenum;
                }

                public String getSellerid() {
                    return sellerid;
                }

                public void setSellerid(String sellerid) {
                    this.sellerid = sellerid;
                }

                public String getSubhead() {
                    return subhead;
                }

                public void setSubhead(String subhead) {
                    this.subhead = subhead;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class TuijianBean {
            private String name;
            private List<ListBeanX> list;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {
                private String bargainPrice;
                private String createtime;
                private String detailUrl;
                private String images;
                private String itemtype;
                private String pid;
                private String price;
                private String pscid;
                private String salenum;
                private String sellerid;
                private String subhead;
                private String title;


                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }

                public String getDetailUrl() {
                    return detailUrl;
                }

                public void setDetailUrl(String detailUrl) {
                    this.detailUrl = detailUrl;
                }

                public String getImages() {
                    return images;
                }

                public void setImages(String images) {
                    this.images = images;
                }

                public String getBargainPrice() {
                    return bargainPrice;
                }

                public void setBargainPrice(String bargainPrice) {
                    this.bargainPrice = bargainPrice;
                }

                public String getItemtype() {
                    return itemtype;
                }

                public void setItemtype(String itemtype) {
                    this.itemtype = itemtype;
                }

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getPscid() {
                    return pscid;
                }

                public void setPscid(String pscid) {
                    this.pscid = pscid;
                }

                public String getSalenum() {
                    return salenum;
                }

                public void setSalenum(String salenum) {
                    this.salenum = salenum;
                }

                public String getSellerid() {
                    return sellerid;
                }

                public void setSellerid(String sellerid) {
                    this.sellerid = sellerid;
                }

                public String getSubhead() {
                    return subhead;
                }

                public void setSubhead(String subhead) {
                    this.subhead = subhead;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class BannerBean {
            private String aid;
            private String createtime;
            private String icon;
            private String productId;
            private String title;
            private String type;
            private String url;


            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getProductId() {
                return productId;
            }


            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }


            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getAid() {
                return aid;
            }

            public void setAid(String aid) {
                this.aid = aid;
            }

            public void setProductId(String productId) {
                this.productId = productId;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class FenleiBean {
            private String cid;
            private String createtime;
            private String icon;
            private String ishome;
            private String name;


            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getIshome() {
                return ishome;
            }

            public void setIshome(String ishome) {
                this.ishome = ishome;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
