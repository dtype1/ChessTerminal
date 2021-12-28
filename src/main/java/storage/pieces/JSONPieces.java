package storage.pieces;

public class JSONPieces {
    private final StoragePiece[] storagePiece;
    private int currentIndex;

    public JSONPieces(int size){
        this.storagePiece = new StoragePiece[size];
        this.currentIndex = 0;
    }

    public StoragePiece[] getStoragePiece() {
        return storagePiece;
    }

    public void addStoragePiece(StoragePiece storagePiece) {
        this.storagePiece[currentIndex] = storagePiece;
        this.currentIndex++;
    }
}
