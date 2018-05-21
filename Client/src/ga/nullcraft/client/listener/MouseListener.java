package ga.nullcraft.client.listener;

import ga.nullcraft.client.NuevClient;
import ga.nullcraft.client.graphics.PlayerCamera;
import ga.nullcraft.client.platform.input.mouse.IMouseListener;
import ga.nullcraft.client.platform.input.mouse.MouseButtonEvent;
import ga.nullcraft.client.platform.input.mouse.MouseMoveEvent;
import ga.nullcraft.client.platform.input.mouse.WheelEvent;

public class MouseListener implements IMouseListener {

    boolean mouseLocked = true;
    float MOUSE_SENSITIVITY = 0.2f;
    
    private NuevClient client = NuevClient.getClient();
    private PlayerCamera camera;
    
    public MouseListener(PlayerCamera camera) {
    	this.camera = camera;
    }
    
    @Override
    public void onMouseMove(MouseMoveEvent e) {
        if(mouseLocked) {
        	e.getInput().setPosition(client.getWindowManager().getWindow().getWidth()/2, client.getWindowManager().getWindow().getHeight()/2);
        }

        camera.moveRotation((float) e.getDeltaX() * MOUSE_SENSITIVITY, (float) e.getDeltaY() * MOUSE_SENSITIVITY, 0);
    }

    @Override
    public void onMouseDown(MouseButtonEvent e) {
        System.out.println("update: " + client.getWindowManager().getUpdateThread().getElapsed());
        System.out.println("render: " + client.getWindowManager().getRenderThread().getElapsed());
    }

    @Override
    public void onMouseUp(MouseButtonEvent e) {

    }

    @Override
    public void onScroll(WheelEvent e) {

    }

}