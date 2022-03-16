package com.io.admin.dto.youtube;

import java.util.List;

public class YouTubeMergeDTO {
    String kind;
    String etag;
    List<YouTubeItemsDTO> youtubelista;

    public YouTubeMergeDTO() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public void setYoutubelista(List<YouTubeItemsDTO> youtubelista) {
        this.youtubelista = youtubelista;
    }
}
