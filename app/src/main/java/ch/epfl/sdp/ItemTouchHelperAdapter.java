package ch.epfl.sdp;

// to listen for a move or dismiss event
public interface ItemTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
